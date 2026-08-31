package relacionamentos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class RelacionamentoN_N_Insert {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Curso curso1 = new Curso();
		curso1.setDescricao("ADM");
		curso1.setCargaHoraria(30);
		manager.persist(curso1);
		
		Curso curso2 = new Curso();
		curso2.setDescricao("Direito");
		curso2.setCargaHoraria(90);
		manager.persist(curso2);
		
		Curso curso3 = new Curso();
		curso3.setDescricao("Med");
		curso3.setCargaHoraria(100);
		manager.persist(curso3);
		
		Estudante estudante1 = new Estudante();
		estudante1.setNome("José");
		estudante1.setSexo('M');
		estudante1.setPcd(true);
		estudante1.setIra(new BigDecimal(8));
		estudante1.getCursos().add(curso1);
		estudante1.getCursos().add(curso2);
		manager.persist(estudante1);
		
		Estudante estudante2 = new Estudante();
		estudante2.setNome("Maria");
		estudante2.setSexo('F');
		estudante2.setPcd(false);
		estudante2.setIra(new BigDecimal(10));
		estudante2.getCursos().add(curso1);
		estudante2.getCursos().add(curso3);
		manager.persist(estudante2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
