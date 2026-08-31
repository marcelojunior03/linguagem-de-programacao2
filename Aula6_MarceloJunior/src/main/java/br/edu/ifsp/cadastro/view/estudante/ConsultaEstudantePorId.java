package br.edu.ifsp.cadastro.view.estudante;

import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;
import br.edu.ifsp.cadastro.model.Estudante;

public class ConsultaEstudantePorId {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		Long id;
		String formato = "%1$-2s %2$-25s %3$-15s %4$-12s%n";
		
		System.out.println("\nConsulta de estudante por ID:");
		System.out.print("Informe o ID do estudante: ");
		id = Long.parseLong(entrada.nextLine());
		
		Estudante estudante = new EstudanteController().consultaEstudantePorId(id);
		
		System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PCD", " | IRA");
		System.out.printf(formato, estudante.getId(),
						  " | " + estudante.getNome(),
						  " | " + estudante.getSexo(),
						  " | " + (estudante.getPcd() ? "Sim" : "Não"),
						  " | " + estudante.getIra());
	}
}