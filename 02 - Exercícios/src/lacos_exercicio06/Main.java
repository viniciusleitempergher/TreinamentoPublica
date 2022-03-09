package lacos_exercicio06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe um número");
		int numero = entrada.nextInt();

		entrada.close();

		int multiplicacao = numero;

		for (int i = numero - 1; i >= 1; i--) {
			int oldNumber = multiplicacao;
			multiplicacao = multiplicacao * i;
			System.out.println(oldNumber +  " x " + i + " = " + multiplicacao);
		}
	}
}
