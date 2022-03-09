package condicionais_exercicio04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite um número");
		int numero1 = entrada.nextInt();
		int menor = numero1;

		for (int i = 0; i < 2; i++) {
			System.out.println("Digite um número");
			numero1 = entrada.nextInt();
			menor = menor > numero1 ? numero1 : menor; // Caso o menor seja maior, então o informado será o novo menor.
		}
		
		entrada.close();
		
		System.out.println("O menor número digitado foi: " + menor);
	}
}
