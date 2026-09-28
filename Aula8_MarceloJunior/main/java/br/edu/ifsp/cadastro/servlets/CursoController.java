package br.edu.ifsp.cadastro.servlets;

import java.io.IOException;
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

import br.edu.ifsp.cadastro.entities.Curso;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

@SuppressWarnings("serial")
@WebServlet("/CursoController")
public class CursoController extends HttpServlet {
	EntityManager manager;
	EntityTransaction transaction;
	RequestDispatcher destino;
	
	public CursoController() {
		manager = JpaUtil.getEntityManager();
		transaction = manager.getTransaction();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cursos", consultaCursos());
		destino = getServletContext().getRequestDispatcher("/curso/resultConsulta.jsp");
		destino.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = 0L;
		String descricao = request.getParameter("txDescricao");
		int carga_horaria = 0;
		
		if (request.getParameter("op").equals("exclusao") || request.getParameter("op").equals("alteracao"))
			 id = Long.parseLong(request.getParameter("txId"));
		
		try {			
			if (request.getParameter("op").equals("insercao")) {
				try {
					insereCurso(descricao, carga_horaria);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/curso/resultInsercao.jsp");
			} else if (request.getParameter("op").equals("alteracao")) {
				try {
					alteraCurso(id, descricao, carga_horaria);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/curso/resultAlteracao.jsp");
			} else if (request.getParameter("op").equals("exclusao")) {
				try {
					excluiCurso(id);
					request.setAttribute("resultado", true);
				} catch (Exception e) {
					request.setAttribute("resultado", false);
				}
				destino = getServletContext().getRequestDispatcher("/curso/resultExclusao.jsp");
			}
			destino.forward(request, response);
		} catch (Exception e) {
			destino = getServletContext().getRequestDispatcher("/erroEntrada.jsp");
			destino.forward(request, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> consultaCursos() {
		Query query = manager.createQuery("select e from Curso e");
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

	public void insereCurso(String descricao, int carga_horaria) {
		transaction.begin();
		Curso curso = new Curso();
		curso.setDescricao(descricao);
		curso.setCargaHoraria(carga_horaria);
		manager.persist(curso);
		transaction.commit();
	}

	public void alteraCurso(Long id, String descricao, int carga_horaria) {
		transaction.begin();
		Curso curso = manager.find(Curso.class, id);
		curso.setDescricao(descricao);
		curso.setCargaHoraria(carga_horaria);
		transaction.commit();
	}

	public void excluiCurso(Long id) {
		transaction.begin();
		Curso curso = manager.find(Curso.class, id);
		manager.remove(curso);
		transaction.commit();
	}
}
