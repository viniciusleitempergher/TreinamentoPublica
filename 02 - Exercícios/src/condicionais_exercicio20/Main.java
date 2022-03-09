package condicionais_exercicio20;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Conversor: ");
		System.out.println("1 - Milhas para quilômetros");
		System.out.println("2 - Quilômetros para milhas");
		
		System.out.println("Digite o número da opção:");
		int opcao = entrada.nextInt();
		
		System.out.println("Informe a quantidade:");
		double quantidade = entrada.nextDouble();
		
		entrada.close();
		
		if (opcao == 1) {
			System.out.println("Quantidade em quilômetros: " + quantidade * 1.60934);
		} else if (opcao == 2) {
			System.out.println("Quantidade em milhas: " + quantidade * 0.621371);
		}

	}
}
