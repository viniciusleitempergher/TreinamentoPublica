package vetores_exercicio12;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Matriz de produtos com nome, estoque e valor
		String[][] matriz = new String[30][3];
		
		// adiciona alguns produtos na matriz
		matriz[0][0] = "Notebook";
		matriz[0][1] = "3";
		matriz[0][2] = "1500";
		
		matriz[1][0] = "Leite";
		matriz[1][1] = "15";
		matriz[1][2] = "5";
		
		matriz[2][0] = "Mouse";
		matriz[2][1] = "5";
		matriz[2][2] = "200";
		
		System.out.println("Lista de Produtos: \n");
		for (String[] produto : matriz) {
			if (produto[1] == null || Integer.parseInt(produto[1]) == 0) continue;
			
			System.out.println(produto[0]);
			System.out.println("Estoque: " + produto[1]);
			System.out.println("Preço: " + produto[2]);
			System.out.println();
		}
		System.out.println();
		
		Scanner entrada = new Scanner(System.in);
		String[][] carrinho = new String[30][3];
		
		while (true) {
			System.out.println("Digite o nome do produto para adicionar ao carrinho:");
			String pesquisa = entrada.nextLine();
			
			lacoMatriz: for (int i = 0; i < matriz.length; i++) {
				if (matriz[i][0] != null && matriz[i][0].equalsIgnoreCase(pesquisa)) {
					for (int l = 0; l < carrinho.length; l++) {
						if (carrinho[l][0] == null) {
							carrinho[l][0] = matriz[i][0];
							
							boolean incorreto = true;
							while (incorreto) {
								System.out.println("Digite a quantidade que deseja comprar:");
								carrinho[l][1] = entrada.nextLine();
								
								if (Integer.parseInt(carrinho[l][1]) > Integer.parseInt(matriz[i][1])) {
									System.out.println("Você não pode comprar mais do que o estoque!");
									carrinho[l][1] = "0";
								} else {
									incorreto = false;
								}
							}
							
							carrinho[l][2] = matriz[i][2];
							
							break lacoMatriz;
						}
					}
				}
			}
			
			System.out.println("Deseja continuar? s/n");
			char opcao = entrada.nextLine().charAt(0);
			if (opcao == 'n') break;
		}
		
		entrada.close();
		
		double total = 0;
		System.out.println("\nSeu carrinho:\n");
		for (String[] produto : carrinho) {
			if (produto[1] == null || produto[1].equals("0")) continue;
			System.out.println("Produto: " + produto[0]);
			System.out.println("Quantidade: " + produto[1]);
			System.out.println("Valor unitário: " + produto[2]);
			System.out.println();
			total += Double.parseDouble(produto[2]) * Double.parseDouble(produto[1]);
		}
		System.out.println("Valor Total: " + total);
	}
}
