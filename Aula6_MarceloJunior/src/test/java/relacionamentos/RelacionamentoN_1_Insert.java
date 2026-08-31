package relacionamentos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class RelacionamentoN_1_Insert {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Curso curso = new Curso();
		curso.setDescricao("ADS");
		curso.setCargaHoraria(50);
		manager.persist(curso);
		
		Estudante estudante1 = new Estudante();
		estudante1.setNome("Kleber");
		estudante1.setSexo('M');
		estudante1.setPcd(false);
		estudante1.setIra(new BigDecimal(6));
		estudante1.setCurso(curso);
		manager.persist(estudante1);
		
		Estudante estudante2 = new Estudante();
		estudante2.setNome("Maria");
		estudante2.setSexo('F');
		estudante2.setPcd(false);
		estudante2.setIra(new BigDecimal(10));
		estudante2.setCurso(curso);
		manager.persist(estudante2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
