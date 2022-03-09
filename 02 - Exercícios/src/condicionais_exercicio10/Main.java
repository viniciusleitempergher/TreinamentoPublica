package condicionais_exercicio10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.println("Digite o comprimento do lado1");
		double lado1 = entrada.nextDouble();
		
		System.out.println("Digite o comprimento do lado2");
		double lado2 = entrada.nextDouble();
		
		System.out.println("Digite o comprimento do lado3");
		double lado3 = entrada.nextDouble();
		
		entrada.close();
		
		if (lado1 == lado2 && lado2 == lado3) {
			System.out.println("O triângulo é equilátero.");
		} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
			System.out.println("O triângulo é isósceles.");
		} else {
			System.out.println("O triângulo é escaleno.");
		}
	}
}
