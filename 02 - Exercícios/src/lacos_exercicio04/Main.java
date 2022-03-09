package lacos_exercicio04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int soma = 0;
		
		while (true) {
			int numero = entrada.nextInt();
			
			if (numero == 0) {
				break;
			}
			
			soma += numero;
		}
		
		entrada.close();
		
		System.out.println("O resultado da soma é: " + soma);
	}
}
