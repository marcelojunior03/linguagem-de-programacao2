package br.edu.ifsp.cadastro.view;

import java.util.Scanner;

import br.edu.ifsp.cadastro.controller.EstudanteController;
import br.edu.ifsp.cadastro.view.estudante.AlteraEstudante;
import br.edu.ifsp.cadastro.view.estudante.ConsultaEstudantePorId;
import br.edu.ifsp.cadastro.view.estudante.ConsultaEstudantes;
import br.edu.ifsp.cadastro.view.estudante.ExcluiEstudante;
import br.edu.ifsp.cadastro.view.estudante.InsereEstudante;

public class Index {
	public static void main(String[] args) {
		int opcao = 0;
		
		Scanner entrada = new Scanner(System.in);

        do {
			System.out.println("Cadastro de estudantes:");
			System.out.println("1) Inserir");
			System.out.println("2) Consultar");
			System.out.println("3) Consultar por Id");
			System.out.println("4) Alterar");
			System.out.println("5) Excluir");
			System.out.print("Digite uma opção (0 para sair): ");
		
		    opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                	InsereEstudante.exibeInterface();
                    break;
                case 2:
                	ConsultaEstudantes.exibeInterface();
                    break;
                case 3:
                	ConsultaEstudantePorId.exibeInterface();
                    break;
                case 4:
                	AlteraEstudante.exibeInterface();
                    break;
                case 5:
                	ExcluiEstudante.exibeInterface();
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Digite uma opção válida.");
                    else {
                    	new EstudanteController().finalizaEntityManager();
                    	System.out.println("Programa encerrado.");
                    }
                    break;
            }
            System.out.println();
        } while (opcao != 0);
        
        entrada.close();
	}
}