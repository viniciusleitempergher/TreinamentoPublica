package vetores_exercicio13;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		// Matriz de pessoas com nome e idade
		String[][] pessoas = new String[10][2];
		
		Scanner entrada = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Digite um nome:");
			pessoas[i][0] = entrada.nextLine();
			
			System.out.println("Digite a idade:");
			pessoas[i][1] = entrada.nextLine();
			
			System.out.println("Deseja continuar? (s/n)");
			char opcao = entrada.nextLine().charAt(0);
			if (opcao == 'n') break;
		}
		
		entrada.close();

		String nomeVelho = "";
		int idadeVelho = 0;
		String nomeJovem = "";
		int idadeJovem = 0;
		double soma = 0;
		int quantidadePessoas = 0;
		for (int i = 0; i < 10; i++) {
			if (pessoas[i][0] != null) {
				if (i == 0) {
					nomeVelho = pessoas[i][0];
					idadeVelho = Integer.parseInt(pessoas[i][1]);

					nomeJovem = pessoas[i][0];
					idadeJovem = Integer.parseInt(pessoas[i][1]);
				} else if (idadeVelho < Integer.parseInt(pessoas[i][1])) {
					nomeVelho = pessoas[i][0];
					idadeVelho = Integer.parseInt(pessoas[i][1]);
				} else if (idadeJovem > Integer.parseInt(pessoas[i][1])) {
					nomeJovem = pessoas[i][0];
					idadeJovem = Integer.parseInt(pessoas[i][1]);
				}
				soma += Integer.parseInt(pessoas[i][1]);
				quantidadePessoas++;
			}
		}
		
		System.out.println("Mais jovem: " + nomeJovem);
		System.out.println("Idade: " + idadeJovem);
		System.out.println();
		System.out.println("Mais velho: " + nomeVelho);
		System.out.println("Idade: " + idadeVelho);
		System.out.println();
		System.out.println("Média das idades: " + soma / quantidadePessoas);
	}
}
