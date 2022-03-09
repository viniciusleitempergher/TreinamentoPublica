package vetores_exercicio15;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Matriz de alunos com nome, g�nero e tr�s notas
		String[][] alunos = new String[30][5];
		
		Scanner entrada = new Scanner(System.in);
		infinito: while (true) {
			System.out.println("\nSistema de Alunos: \n");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Remover");
			System.out.println("5 - Estat�sticas");
			System.out.println("6 - Sair do sistema\n");
			System.out.println("Digite o n�mero da op��o:");
			
			int opcao = Integer.parseInt(entrada.nextLine());
			
			switch (opcao) {
			case 1:
				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][0] == null) {
						alunos = editaInformacoes(alunos, entrada, i);
						break;
					}
				}
				break;
			case 2:
				System.out.println("\nLista de alunos:\n");
				for (String[] aluno : alunos) {
					if (aluno[0] == null) continue;
					
					System.out.println("\nNome: " + aluno[0]);
					System.out.println("G�nero: " + aluno[1].toUpperCase());
					System.out.println("Nota 1: " + aluno[2]);
					System.out.println("Nota 2: " + aluno[3]);
					System.out.println("Nota 3: " + aluno[4]);
					
					double media = (Double.parseDouble(aluno[2]) + Double.parseDouble(aluno[3]) 
						+ Double.parseDouble(aluno[4])) / 3;
					System.out.println("M�dia: " + media);
					System.out.println("Situa��o: " + (media >= 7 ? "Aprovado" : "Reprovado"));
					
				}
				break;
			case 3:
				int posicaoAluno = -1;
				while (posicaoAluno < 0) {
					System.out.println("Digite o nome a ser alterado: ");
					String nome = entrada.nextLine();
					
					posicaoAluno = pesquisarNome(nome, alunos);
					if (posicaoAluno < 0) System.out.println("Nome n�o encontrado!");
				}
				
				alunos = editaInformacoes(alunos, entrada, posicaoAluno);
				
				break;
			case 4:
				posicaoAluno = -1;
				while (posicaoAluno < 0) {
					System.out.println("Digite o nome a ser removido: ");
					String nome = entrada.nextLine();
					
					posicaoAluno = pesquisarNome(nome, alunos);
					if (posicaoAluno < 0) System.out.println("Nome n�o encontrado!");
				}
				
				for (int i = 0; i < 5; i++) alunos[posicaoAluno][i] = null;
				
				System.out.println("Aluno removido!");
				
				break;
			case 5:
				System.out.println("\nEstat�sticas:\n");
				
				int quantidadeAlunos = 0;
				int quantidadeAprovados = 0;
				int quantidadeReprovados = 0;
				
				for (String[] aluno : alunos) {
					if (aluno[0] == null) continue;
					quantidadeAlunos++;
					double media = (Double.parseDouble(aluno[2]) + Double.parseDouble(aluno[3]) 
						+ Double.parseDouble(aluno[4])) / 3;
					
					if (media >= 7) quantidadeAprovados++;
					else quantidadeReprovados++;
				}
				
				System.out.println("Quantidade de alunos: " + quantidadeAlunos);
				System.out.println("Quantidade de alunos aprovados: " + quantidadeAprovados);
				System.out.println("Quantidade de alunos reprovados: " + quantidadeReprovados);
				
				break;
			case 6:
				break infinito;
			}
		}
		
		System.out.println("Obrigado por utilizar!");
		
		entrada.close();
	}
	
	static String[][] editaInformacoes(String[][] alunos, Scanner entrada, int linha) {

		boolean correto = false;
		String nome = "";
		while (!correto) {
			System.out.println("Digite o nome do aluno:");
			nome = entrada.nextLine();
			
			correto = true;
			
			for (int l = 0; l < alunos.length; l++) {
				if (alunos[l][0] != null && alunos[l][0].equalsIgnoreCase(nome)) {
					correto = false;
					System.out.println("Voc� digitou um nome duplicado!");
				}
			}
		}
		
		alunos[linha][0] = nome;
		
		System.out.println("Digite o g�nero do aluno: M/F");
		alunos[linha][1] = entrada.nextLine().charAt(0) + "";
		
		for (int l = 0; l < 3; l++) {
			System.out.println("Digite a nota " + (l + 1));
			alunos[linha][l + 2] = entrada.nextLine();
		}

		return alunos;
	}
	
	// Retorna a linha com o nome pesquisado
	// Caso n�o exista, retorna -1
	static int pesquisarNome(String nome, String[][] alunos) {
		for (int i = 0; i < alunos.length; i++) {
			if (nome.equalsIgnoreCase(alunos[i][0])) {
				return i;
			}
		}
		return -1;
	}
}
