package br.edu.ifsp.cadastro.view.estudante;

import java.math.BigDecimal;
import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;

public class AlteraEstudante {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		Long id;
		String nome;
		Character sexo;
		Boolean pcd;
		BigDecimal ira = null;
		
		System.out.println("\nAlteração de estudante:");
		System.out.print("Informe o Id do estudante a ser alterado: ");
		id = Long.parseLong(entrada.nextLine());
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		System.out.print("Sexo: ");
		String scanSexo = entrada.nextLine();
		sexo = Character.valueOf(scanSexo.charAt(0));
		System.out.print("PCD (digite 's' ou 'n'): ");
		pcd = (entrada.nextLine().equals("s") ? true : false);
		System.out.print("IRA: ");
		ira = new BigDecimal(entrada.nextLine());
		
		new EstudanteController().alteraEstudante(id, nome, sexo, pcd, ira);
		System.out.println("Estudante alterado com sucesso!\n");
	}
}
