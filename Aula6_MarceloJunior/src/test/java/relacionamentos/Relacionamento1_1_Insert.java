package relacionamentos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class Relacionamento1_1_Insert {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Curso curso = new Curso();
		curso.setDescricao("Sistemas de Informação");
		curso.setCargaHoraria(80);
		manager.persist(curso);
		
		Estudante estudante = new Estudante();
		estudante.setNome("Ana");
		estudante.setSexo('F');
		estudante.setPcd(true);
		estudante.setIra(new BigDecimal(9));
		estudante.setCurso(curso);
		manager.persist(estudante);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
