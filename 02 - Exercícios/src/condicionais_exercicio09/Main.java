package condicionais_exercicio09;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a velocidade máxima da via:");
		double maxima = entrada.nextDouble();
		
		System.out.println("Digite a velocidade do veículo");
		double velocidadeVeiculo = entrada.nextDouble();
		
		entrada.close();
		
		if (velocidadeVeiculo <= maxima) {
			System.out.println("Bom motorista.");
		} else if (velocidadeVeiculo <= maxima + 10) {
			System.out.println("Multa de R$50,00");
		} else if (velocidadeVeiculo <= maxima + 20) {
			System.out.println("Multa de R$100,00");
		} else {
			System.out.println("Multa de R$200,00");
		}
		
	}
}
