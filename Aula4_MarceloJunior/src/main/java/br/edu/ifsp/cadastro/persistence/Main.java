package br.edu.ifsp.cadastro.persistence;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		manager.close();
	}

}
