package br.edu.ifsp.cadastro.view.estudante;

import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;
import br.edu.ifsp.cadastro.model.Estudante;

public class ConsultaEstudantes {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		String formato = "%1$-2s %2$-25s %3$-15s %4$-12s%n";
		
		System.out.println("\nConsulta de estudantes:");
		System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PCD", " | IRA");
		
		for (Estudante estudante : new EstudanteController().consultaEstudantes()) {
			System.out.printf(formato, estudante.getId(),
							  " | " + estudante.getNome(),
							  " | " + estudante.getSexo(),
							  " | " + (estudante.getPcd() ? "Sim" : "Não"),
							  " | " + estudante.getIra());
		}
		System.out.println();
		exibeOpcoesAlterarExcluir();
	}
	
	public static void exibeOpcoesAlterarExcluir() {
		int opcao = 0;
		
		do {
			System.out.println("Alteração / exclusão de estudante:");
			System.out.println("1) Alterar");
			System.out.println("2) Excluir");
			System.out.print("Digite uma opção (0 para voltar): ");
			
			opcao = Integer.parseInt(entrada.nextLine());
			System.out.println();
			
			switch(opcao) {
			case 0:
				break;
			case 1:
				AlteraEstudante.exibeInterface();
				break;
			case 2:
				ExcluiEstudante.exibeInterface();
				break;
			default:
				if (opcao != 1 && opcao != 2) {
					System.out.println("Digite uma opção válida!");
					break;
				}
			}
		}while(opcao != 0 && opcao != 1 && opcao != 2);
	}
}