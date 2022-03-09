package vetores_exercicio11;

import java.util.Scanner;

public class Main {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Matriz de produtos com nome, valor e marca.
		String[][] matriz = new String[50][3];
		
		loop: while (true) {
			System.out.println("\nSistema de cadastro!");
			System.out.println("Opção 1 - Cadastrar;");
			System.out.println("Opção 2 - Listar todos os produtos;;");
			System.out.println("Opção 3 - Alterar produtos;"); //(pesquise pelo nome do produto, peça o nome, valor e marca para efetuar a alteração);
			System.out.println("Opção 4 - Remover produtos;"); //(remova pelo nome do produto);
			System.out.println("Opção 5 - Finalizar sistema.");
			System.out.println("Digite uma opção:");
			int opcao = Integer.parseInt(entrada.nextLine());
			
			switch (opcao) {
			// Cadastrar
			case 1:
				for (int i = 0; i < matriz.length; i++) {
					if (matriz[i][0] == null) {
						matriz = escreverNaMatriz(i, matriz);
						break;
					}
				}
				break;
			// Listar
			case 2:
				System.out.println("Produtos cadastrados:");
				for (String[] item : matriz) {
					if (item[0] == null) continue;
					System.out.println("Nome: " + item[0]);
					System.out.println("Valor: " + item[1]);
					System.out.println("Marca: " + item[2]);
					System.out.println();
				}
				break;
			// Alterar
			case 3:
				int linhaPesquisada = -1;
				while (linhaPesquisada == -1) {
					System.out.println("Informe o nome a ser alterado:");
					linhaPesquisada = pesquisarNome(entrada.nextLine(), matriz);
					if (linhaPesquisada == -1) System.out.println("Nome não encontrado.");
					else {
						System.out.println("Produto encontrado! Digite os novos dados:");
						matriz = escreverNaMatriz(linhaPesquisada, matriz);
						break;
					}
				}
				break;
			// Remover
			case 4:
				linhaPesquisada = -1;
				while (linhaPesquisada == -1) {
					System.out.println("Informe o nome a ser removido:");
					linhaPesquisada = pesquisarNome(entrada.nextLine(), matriz);
					if (linhaPesquisada == -1) System.out.println("Nome não encontrado.");
					else {
						matriz[linhaPesquisada][0] = null;
						matriz[linhaPesquisada][1] = null;
						matriz[linhaPesquisada][2] = null;
						
						System.out.println("Produto removido!");
						break;
					}
				}
				break;
			case 5:
				System.out.println("Finalizando o sistema, obrigado por utilizar!");
				break loop;
			default:
				System.out.println("Opção inválida!");
			}
		}
		entrada.close();

	}

	// Pede as informações do produto, escreve na linha recebida da matriz recebida
	// 			como parâmetro e retorna a matriz alterada
	static String[][] escreverNaMatriz(int linha, String[][] matriz) {
		String[] colunas = new String[3];
		
		System.out.println("Informe o nome:");
		colunas[0] = entrada.nextLine();

		System.out.println("Informe o valor:");
		colunas[1] = entrada.nextLine();

		System.out.println("Informe a marca:");
		colunas[2] = entrada.nextLine();

		matriz[linha][0] = colunas[0];
		matriz[linha][1] = colunas[1];
		matriz[linha][2] = colunas[2];

		System.out.println("Produto registrado!");

		return matriz;
	}

	// Retorna a linha com o nome pesquisado
	// Caso não exista, retorna -1
	static int pesquisarNome(String nome, String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			if (nome.equalsIgnoreCase(matriz[i][0])) {
				return i;
			}
		}
		return -1;
	}
}
