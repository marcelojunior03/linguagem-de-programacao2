package relacionamentos;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifsp.cadastro.model.Estudante;
import br.edu.ifsp.cadastro.persistence.JpaUtil;

public class Relacionamento1_1_Select {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		List<Estudante> estudantes = manager.createQuery("select 1 from Estudante 1 inner join fetch 1.curso", Estudante.class).getResultList();
		String formato = "%1$-2s %2$-30s %3$-15s %4$-15s %5$-25s%n";
		
		System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PCD", " | IRA", " | CURSO");
		for(Estudante estudante : estudantes) {
			System.out.printf(formato, estudante.getId(),
							  " | " + estudante.getNome(),
							  " | " + estudante.getSexo(),
							  " | " + (estudante.getPcd() ? "Sim" : "Não"),
							  " | " + estudante.getIra(),
							  " | " + estudante.getCurso().getDescricao());
			manager.close();
			JpaUtil.close();
		}

	}

}
