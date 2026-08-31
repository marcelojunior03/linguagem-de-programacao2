package relacionamentos;

import javax.persistence.EntityManager;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class RelacionamentoN_N_Select2_Bidirecional {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Curso curso = manager.find(Curso.class, 1L);
		System.out.println("Estudantes do Curso '" + curso.getDescricao() + "': ");
		for(Estudante estudante : curso.getEstudantes()) {
			System.out.println(estudante.getNome());
		}
		
		manager.close();
		JpaUtil.close();

	}

}
