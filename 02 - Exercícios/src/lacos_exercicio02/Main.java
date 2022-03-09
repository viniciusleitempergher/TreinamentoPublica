package lacos_exercicio02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um número:");
		int numero = entrada.nextInt();
		
		entrada.close();
		
		System.out.println("10 antecessores: ");
		for (int i = numero - 1; i >= numero - 10; i--) {
			System.out.println(i);
		}

		System.out.println("10 sucessores: ");
		for (int i = numero + 1; i <= numero + 10; i++) {
			System.out.println(i);
		}
	}
}
