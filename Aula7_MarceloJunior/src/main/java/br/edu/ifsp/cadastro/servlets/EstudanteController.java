package br.edu.ifsp.cadastro.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.ifsp.cadastro.entities.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

@SuppressWarnings("serial")
@WebServlet("/LivroController")
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
		request.setAttribute("estudantes", consultaEstudantes());
		destino = getServletContext().getRequestDispatcher("/estudante/resultConsulta.jsp");
		destino.forward(request, response);
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
		
		try {
			if (request.getParameter("op").equals("exclusao") || request.getParameter("op").equals("alteracao"))
				 id = Long.parseLong(request.getParameter("txId"));
			
			if (request.getParameter("op").equals("insercao") || request.getParameter("op").equals("alteracao")) {
				if (!request.getParameter("txIra").equals(null))
					ira = new BigDecimal(request.getParameter("txIra").replace(",", "."));
				if (request.getParameter("ckPcd") == null)
					pcd = false;
			}
			
			if (request.getParameter("op").equals("insercao")) {
				try {
					insereEstudante(nome, sexo, pcd, ira);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/estudante/resultInsercao.jsp");
			} else if (request.getParameter("op").equals("alteracao")) {
				try {
					alteraEstudante(id, nome, sexo, pcd, ira);
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
		Query query = manager.createQuery("select e from Estudante e");
		List<Estudante> Estudantes = query.getResultList();
		return Estudantes;
	}

	public void insereEstudante(String nome, Character sexo, Boolean pcd, BigDecimal ira) {
		transaction.begin();
		Estudante estudante = new Estudante();
		estudante.setNome(nome);
		estudante.setSexo(sexo);
		estudante.setPcd(pcd);
		estudante.setIra(ira);
		manager.persist(estudante);
		transaction.commit();
	}

	public void alteraEstudante(Long id, String nome, Character sexo, Boolean pcd, BigDecimal ira) {
		transaction.begin();
		Estudante estudante = manager.find(Estudante.class, id);
		estudante.setNome(nome);
		estudante.setSexo(sexo);
		estudante.setPcd(pcd);
		estudante.setIra(ira);
		transaction.commit();
	}

	public void excluiEstudante(Long id) {
		transaction.begin();
		Estudante estudante = manager.find(Estudante.class, id);
		manager.remove(estudante);
		transaction.commit();
	}
}