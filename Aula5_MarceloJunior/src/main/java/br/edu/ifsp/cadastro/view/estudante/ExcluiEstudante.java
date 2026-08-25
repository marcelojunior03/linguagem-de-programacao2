package br.edu.ifsp.cadastro.view.estudante;

import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;

public class ExcluiEstudante {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		Long id;
		
		System.out.println("\nExclusão de estudante:");
		System.out.print("Informe o Id do estudante a ser excluído: ");
		id = Long.parseLong(entrada.nextLine());
		
		new EstudanteController().excluiEstudante(id);
		System.out.println("Estudante excluído com sucesso!\n");
	}
}
