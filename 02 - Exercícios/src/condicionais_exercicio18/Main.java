package condicionais_exercicio18;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a nota 1");
		double nota1 = entrada.nextDouble();
		
		System.out.println("Digite a nota 2");
		double nota2 = entrada.nextDouble();
		
		entrada.close();
		
		if (nota1 < 7 || nota2 < 7) {
			System.out.println("Você foi reprovado.");
		} else {
			System.out.println("Aprovado!");
		}
	}
}
