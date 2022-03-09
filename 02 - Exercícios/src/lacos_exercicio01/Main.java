package lacos_exercicio01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um número");
		double numero = entrada.nextDouble();
		
		entrada.close();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " * " + i + " = " + numero * i);
		}
	}
}
