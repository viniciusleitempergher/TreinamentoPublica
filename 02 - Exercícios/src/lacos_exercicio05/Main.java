package lacos_exercicio05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String nomeMaisVelho = "";
		int idadeMaisVelho = 0;
		
		while (true) {
			System.out.println("Digite um nome");
			String nome = entrada.next();

			System.out.println("Digite a idade");
			int idade = entrada.nextInt();
			
			if (idade > idadeMaisVelho) {
				nomeMaisVelho = nome;
				idadeMaisVelho = idade;
			}
			
			System.out.println("Quer informar mais nomes? y/n");
			char c = entrada.next().charAt(0);
			
			if (c == 'n') {
				break;
			}
		}
		entrada.close();
		
		System.out.println("O mais velho é " + nomeMaisVelho);
		System.out.println("Com " + idadeMaisVelho + " anos.");
	}
}
