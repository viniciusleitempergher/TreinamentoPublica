package condicionais_exercicio13;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Conversor de temperaturas");
		System.out.println("Opção 1 - Celsius para Fahrenheit");
		System.out.println("Opção 2 - Fahrenheit para Celsius");
		
		System.out.println("Digite o número da opção:");
		int opcao = entrada.nextInt();
		
		System.out.println("Digite a temperatura a ser convertida:");
		double temperatura = entrada.nextDouble();
		
		entrada.close();
		
		switch (opcao) {
		case 1:
			temperatura = (temperatura * 9/5) + 32;
			break;
		case 2:
			temperatura = (temperatura - 32) * 5/9;
			break;
		}
		
		System.out.print("Temperatura convertida: " + temperatura);
		System.out.println(opcao == 1 ? "Fº" : "Cº");
	}
}
