package condicionais_exercicio02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número:");
		int numero1 = entrada.nextInt();
		
		System.out.println("Digite o segundo número");
		int numero2 = entrada.nextInt();
		
		entrada.close();
		
		int resultado;
		
		if (numero1 == numero2) {
			resultado = numero1 + numero2;
		} else {
			resultado = numero1 * numero2;
		}
		
		System.out.println("O resultado é: " + resultado);
	}
}
