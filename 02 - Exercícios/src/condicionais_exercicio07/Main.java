package condicionais_exercicio07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um n�mero:");
		int numero = entrada.nextInt();

		entrada.close();

		if (numero > 0) {
			System.out.println("O n�mero informado � positivo!");
		} else if (numero < 0) {
			System.out.println("O n�mero informado � negativo!");
		} else {
			System.out.println("O n�mero � zero!");
		}
	}
}
