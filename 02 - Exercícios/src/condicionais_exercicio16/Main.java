package condicionais_exercicio16;

import java.util.Scanner;

public class Main {
	/*
		Valor hora: R$10,00
		Horas trabalhadas normalmente: 10 horas
		Horas trabalhadas com acréscimo de 50%: 10 horas
		Horas trabalhadas com acréscimo de 100%: 10 horas
	 */
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o valor hora:");
		double valorHora = entrada.nextDouble();
		
		System.out.println("Digite as horas trabalhadas normalmente:");
		double horasTrabalhadas = entrada.nextDouble();
		
		System.out.println("Digite as horas com acréscimo de 50%:");
		double horasCom50 = entrada.nextDouble();
		
		System.out.println("Digite as horas com acréscimo de 100%");
		double horasCom100 = entrada.nextDouble();		
		
		entrada.close();
		
		System.out.println("Horas trabalhadas: R$" + valorHora * horasTrabalhadas);
		System.out.println("Horas extras 50%: R$" + valorHora * horasCom50 * 1.5);
		System.out.println("Horas extras 100%: R$" + valorHora * horasCom100 * 2);
		
		double total = valorHora * horasTrabalhadas + valorHora * horasCom50 * 1.5 + valorHora * horasCom100 * 2;
		
		System.out.println("Salário total: R$" + total);
	}	
	
}
