package condicionais_exercicio19;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Cálculo de IMC");
		
		System.out.println("Informe o peso:");
		double peso = entrada.nextDouble();
		
		System.out.println("Informe a altura:");
		double altura = entrada.nextDouble();

		double imc = peso / (altura * altura);
		
		if (imc < 17.5) {
			System.out.println("Abaixo do peso.");
		} else if (imc < 25) {
			System.out.println("Peso normal.");
		} else if (imc < 30) {
			System.out.println("Acima do peso.");
		} else if (imc < 35) {
			System.out.println("Obesidade 1.");
		} else if (imc < 40) {
			System.out.println("Obesidade 2.");
		} else {
			System.out.println("Obesidade 3.");
		}
		
		entrada.close();
	}
}
