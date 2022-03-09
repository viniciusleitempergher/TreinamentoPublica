package vetores_exercicio01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int[] vetor1 = new int[10];
		int[] vetor2 = new int[10];

		for (int i = 0; i < 10; i++) {
			System.out.println("Digite um n�mero para o vetor 1:");
			vetor1[i] = entrada.nextInt();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Digite um n�mero para o vetor 2:");
			vetor2[i] = entrada.nextInt();
		}

		System.out.println("Opera��es:");
		System.out.println("1 - Soma");
		System.out.println("2 - Subtra��o");
		System.out.println("3 - Divis�o");
		System.out.println("4 - Multiplica��o");
		System.out.println("Digite um n�mero:");
		int opcao = entrada.nextInt();
		entrada.close();

		for (int i = 0; i < 10; i++) {
			if (opcao == 1) {
				vetor1[i] += vetor2[i];
			}
			if (opcao == 2) {
				vetor1[i] -= vetor2[i];
			}
			if (opcao == 3) {
				vetor1[i] /= vetor2[i];
			}
			if (opcao == 4) {
				vetor1[i] *= vetor2[i];
			}
		}

		System.out.println("Resultado:");
		for (int n : vetor1) {
			System.out.print(n + " ");
		}
	}
}
