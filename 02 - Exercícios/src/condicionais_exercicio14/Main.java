package condicionais_exercicio14;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o valor do sal�rio:");
		double salario = entrada.nextDouble();
		
		System.out.println("Digite o valor da conta de luz:");
		salario -= entrada.nextDouble();
		
		System.out.println("Digite o valor da conta de telefone:");
		salario -= entrada.nextDouble();
		
		System.out.println("Digite o valor da conta de �gua:");
		salario -= entrada.nextDouble();
		
		System.out.println("Digite o valor da conta do mercado:");
		salario -= entrada.nextDouble();
		
		System.out.println("Digite o valor da conta de lazer:");
		salario -= entrada.nextDouble();
		
		System.out.println("Digite o valor da conta de aluguel:");
		salario -= entrada.nextDouble();
		
		entrada.close();
		
		System.out.println("Ir� sobrar " + salario + " reais do seu sal�rio.");
		
	}
}
