package condicionais_exercicio12;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite os lados de um quadrado:");

		System.out.println("Lado 1:");
		double ultimoLado = entrada.nextDouble();

		System.out.println("Lado 2:");
		if (entrada.nextDouble() != ultimoLado)
			terminaProgramaNaoQuadrado();
		
		System.out.println("Lado 3:");
		if (entrada.nextDouble() != ultimoLado)
			terminaProgramaNaoQuadrado();
		
		System.out.println("Lado 4:");
		if (entrada.nextDouble() != ultimoLado)
			terminaProgramaNaoQuadrado();

		entrada.close();
		
		System.out.println("Os lados s�o iguais, � um quadrado.");
	}

	// Sai do programa informando que n�o � um quadrado
	static void terminaProgramaNaoQuadrado() {
		System.out.println("Os lados n�o s�o iguais, n�o � um quadrado.");
		System.exit(0);
	}
}
