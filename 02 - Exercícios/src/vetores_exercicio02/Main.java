package vetores_exercicio02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int[] vetor = new int[5];
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o valor " + (i + 1));
			vetor[i] = entrada.nextInt();
		}
		
		entrada.close();
		
		for (int i = 0; i < vetor.length - 1; i++) {
			for (int l = 0; l < vetor.length - 1; l++) {
				if (vetor[l] > vetor[l + 1]) {
					int aux = vetor[l];
					vetor[l] = vetor[l + 1];
					vetor[l + 1] = aux;
				}
			}
		}
		
		System.out.println("Vetor ordenado: ");
		for (int n : vetor) {
			System.out.print(n);
		}
	}
}
