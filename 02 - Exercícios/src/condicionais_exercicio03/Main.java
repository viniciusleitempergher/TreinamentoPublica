package condicionais_exercicio03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um ano:");
		int ano = entrada.nextInt();
		
		entrada.close();
		
		if (ano % 4 == 0) {
			System.out.println("O ano é bissexto.");
		} else {
			System.out.println("O ano não é bissexto.");
		}
	}
}
