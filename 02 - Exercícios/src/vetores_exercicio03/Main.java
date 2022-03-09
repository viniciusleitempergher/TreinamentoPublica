package vetores_exercicio03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int[] vetor = new int[10];
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o número " + (i + 1));
			int numeroDigitado = entrada.nextInt();

			boolean foiDigitado = false;
			for (int n : vetor) {
				if (numeroDigitado == n) {
					foiDigitado = true;
					break;
				}
			}
			
			if (foiDigitado) {
				System.out.println("Esse número já foi digitado.");
				i--;
				continue;
			}
			
			vetor[i] = numeroDigitado;
		}
		
		entrada.close();
		
		System.out.println("Vetor:");
		for (int n : vetor) {
			System.out.print(n + " ");
		}
	}
}
