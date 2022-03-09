package lacos_exercicio07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o valor");
		double valor = entrada.nextDouble();
		
		System.out.println("Informe a taxa de juros mensal");
		double taxa = entrada.nextDouble();
		
		System.out.println("Informe a quantidade de meses");
		double meses = entrada.nextDouble();
		
		entrada.close();
		
		for (int i = 1; i <= meses; i++) {
			valor = valor + valor * taxa / 100;
			System.out.println("Mês " + i);
			System.out.println("Ganhos " + valor * taxa / 100);
			System.out.println("Total " + valor);
			
		}
	}
}
