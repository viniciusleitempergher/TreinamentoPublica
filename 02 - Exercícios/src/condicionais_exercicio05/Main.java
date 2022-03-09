package condicionais_exercicio05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		double soma = 0;
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Digite uma nota:");
			double nota = entrada.nextDouble();
			soma += nota;
		}
		
		entrada.close();
		
		double media = soma / 4;
		
		if (media < 5) {
			System.out.println("Reprovado!");
		} else if (media < 7) {
			System.out.println("Em exame!");
		} else {
			System.out.println("Aprovado!");
		}
	}
}
