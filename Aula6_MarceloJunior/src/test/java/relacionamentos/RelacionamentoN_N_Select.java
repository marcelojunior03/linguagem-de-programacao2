package relacionamentos;

import javax.persistence.EntityManager;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class RelacionamentoN_N_Select {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Estudante estudante = manager.find(Estudante.class, 2L);
		System.out.println("Cursos do Estudante '" + estudante.getNome());
		for(Curso curso : estudante.getCursos()) {
			System.out.println(curso.getDescricao());
		}
		
		manager.close();
		JpaUtil.close();

	}

}
