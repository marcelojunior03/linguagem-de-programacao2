package br.edu.ifsp.cadastro.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class EstudanteController {
	EntityManager manager;
	EntityTransaction transaction;
	
	public EstudanteController() {
		manager = JpaUtil.getEntityManager();
		transaction = manager.getTransaction();
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
	
	@SuppressWarnings("unchecked")
	public List<Estudante> consultaEstudantes() {
		Query query = manager.createQuery("select 1 from Estudante 1");
		List<Estudante> estudantes = query.getResultList();
		return estudantes;
	}
	
	public Estudante consultaEstudantePorId(Long id) {
		Estudante estudante = manager.find(Estudante.class, id);
		return estudante;
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
}
