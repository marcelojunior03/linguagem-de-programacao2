package relacionamentos;

import javax.persistence.EntityManager;

import br.edu.ifsp.cadastro.model.Curso;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class Relacionamento1_1_Select2_Bidirecional {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Curso curso = manager.find(Curso.class, 2L);
		System.out.println("Estudante do Curso '" + curso.getDescricao() + "': " + curso.getEstudante().getNome());
		
		manager.close();
		JpaUtil.close();

	}

}
