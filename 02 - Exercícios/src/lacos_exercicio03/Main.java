package lacos_exercicio03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número:");
		int menor = entrada.nextInt();
		System.out.println("Digite outro número:");
		int maior = entrada.nextInt();
		
		entrada.close();
		
		if (maior < menor) {
			int aux = maior;
			maior = menor;
			menor = aux;
		}
		
		while (menor <= maior) {
			System.out.println(menor++);
		}
	}
}
