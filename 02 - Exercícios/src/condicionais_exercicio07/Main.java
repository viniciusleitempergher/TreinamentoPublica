package condicionais_exercicio07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um número:");
		int numero = entrada.nextInt();

		entrada.close();

		if (numero > 0) {
			System.out.println("O número informado é positivo!");
		} else if (numero < 0) {
			System.out.println("O número informado é negativo!");
		} else {
			System.out.println("O número é zero!");
		}
	}
}
