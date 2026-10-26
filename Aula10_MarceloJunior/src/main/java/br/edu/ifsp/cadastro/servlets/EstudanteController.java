package br.edu.ifsp.cadastro.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.edu.ifsp.cadastro.entities.Curso;
import br.edu.ifsp.cadastro.entities.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;
import br.edu.ifsp.cadastro.reports.EstudanteRelatorio;

@SuppressWarnings("serial")
@WebServlet("/EstudanteController")
public class EstudanteController extends HttpServlet {
	EntityManager manager;
	EntityTransaction transaction;
	RequestDispatcher destino;
	
	public EstudanteController() {
		manager = JpaUtil.getEntityManager();
		transaction = manager.getTransaction();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("op").equals("consulta")) {
			request.setAttribute("estudantes", consultaEstudantes());
			destino = getServletContext().getRequestDispatcher("/estudante/resultConsulta.jsp");
			destino.forward(request, response);
		} else if (request.getParameter("op").equals("relatorio")){
			List<EstudanteRelatorio> estudantes = geraRelatorioEstudantes();
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(estudantes);
			InputStream relatorio = getClass().getResourceAsStream("/jasper/ReportLivros.jasper");
			Map<String, Object> parametros = new HashMap<String, Object>();
			try {
				JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, dataSource);
				File pdf = new File("src/main/webapp/reports/RelatorioLivros.pdf");
				JasperExportManager.exportReportToPdfFile(jp, pdf.getAbsolutePath());
				System.out.println("\nRelatório gravado em: " + pdf.getAbsolutePath());
			} catch(Exception e) {
				e.printStackTrace();
			}
			destino = getServletContext().getRequestDispatcher("/estudante/relatorioEstudantes.jsp");
			destino.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = 0L;
		String nome = request.getParameter("txNome");
		Character sexo = null;
		String stringSexo = request.getParameter("rbSexo");
		if(stringSexo != null && !stringSexo.isEmpty()) {
			sexo = stringSexo.charAt(0);
		}
		Boolean pcd = true;
		BigDecimal ira = null;
		Long curso_id = null;
		
		try {
			if (request.getParameter("op").equals("exclusao") || request.getParameter("op").equals("alteracao"))
				 id = Long.parseLong(request.getParameter("txId"));
			
			if (request.getParameter("op").equals("insercao") || request.getParameter("op").equals("alteracao")) {
				if (!request.getParameter("txIra").equals(null))
					ira = new BigDecimal(request.getParameter("txIra").replace(",", "."));
				if (request.getParameter("ckPcd") == null)
					pcd = false;
				if (!request.getParameter("slCurso").equals(""))
					curso_id = Long.parseLong(request.getParameter("slCurso"));
			}
			
			if (request.getParameter("op").equals("insercao")) {
				try {
					insereEstudante(nome, sexo, pcd, ira, curso_id);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/estudante/resultInsercao.jsp");
			} else if (request.getParameter("op").equals("alteracao")) {
				try {
					alteraEstudante(id, nome, sexo, pcd, ira, curso_id);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/estudante/resultAlteracao.jsp");
			} else if (request.getParameter("op").equals("exclusao")) {
				try {
					excluiEstudante(id);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/estudante/resultExclusao.jsp");
			}
			destino.forward(request, response);
		} catch (Exception e) {
			destino = getServletContext().getRequestDispatcher("/erroEntrada.jsp");
			destino.forward(request, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estudante> consultaEstudantes() {
		Query query = manager.createQuery("select e from Estudante e inner join fetch e.curso order by e.id");
		List<Estudante> Estudantes = query.getResultList();
		return Estudantes;
	}
	
	@SuppressWarnings("unchecked")
	public List<EstudanteRelatorio> geraRelatorioEstudantes(){
		Query query = manager.createNativeQuery("SELECT e.id, e.nome, e.sexo, e.pcd, e.ira, c.curso " +
												"FROM Estudante AS e INNER JOIN Curso AS c " +
												"ON e.curso_id = c.id ORDER BY e.id", EstudanteRelatorio.class);
		List<EstudanteRelatorio> estudantes = query.getResultList();
		return estudantes;
	}

	public void insereEstudante(String nome, Character sexo, Boolean pcd, BigDecimal ira, Long curso_id) {
		transaction.begin();
		Estudante estudante = new Estudante();
		estudante.setNome(nome);
		estudante.setSexo(sexo);
		estudante.setPcd(pcd);
		estudante.setIra(ira);
		if (curso_id != null)
			estudante.setCurso(manager.find(Curso.class, curso_id));
		else
			estudante.setCurso(null);
		manager.persist(estudante);
		transaction.commit();
	}

	public void alteraEstudante(Long id, String nome, Character sexo, Boolean pcd, BigDecimal ira, Long curso_id) {
		transaction.begin();
		Estudante estudante = manager.find(Estudante.class, id);
		estudante.setNome(nome);
		estudante.setSexo(sexo);
		estudante.setPcd(pcd);
		estudante.setIra(ira);
		if (curso_id != null)
			estudante.setCurso(manager.find(Curso.class, curso_id));
		else
			estudante.setCurso(null);
		transaction.commit();
	}

	public void excluiEstudante(Long id) {
		transaction.begin();
		Estudante estudante = manager.find(Estudante.class, id);
		manager.remove(estudante);
		transaction.commit();
	}
}