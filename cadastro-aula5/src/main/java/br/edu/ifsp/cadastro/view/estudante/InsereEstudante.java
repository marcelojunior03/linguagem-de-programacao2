package br.edu.ifsp.cadastro.view.estudante;

import java.math.BigDecimal;
import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;

public class InsereEstudante {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		String nome;
		Character sexo;
		Boolean pcd;
		BigDecimal ira = null;
		
		System.out.println("\nInserção de estudante:");
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		System.out.print("Sexo: ");
		String scanSexo = entrada.nextLine();
		sexo = Character.valueOf(scanSexo.charAt(0));
		System.out.print("PCD (digite 's' ou 'n'): ");
		pcd = (entrada.nextLine().equals("s") ? true : false);
		System.out.print("IRA: ");
		ira = new BigDecimal(entrada.nextLine());
		
		new EstudanteController().insereEstudante(nome, sexo, pcd, ira);
		System.out.println("Estudante cadastrado com sucesso!\n");
	}
}
