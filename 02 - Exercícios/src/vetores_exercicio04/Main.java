package vetores_exercicio04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] vetor = new String[100];

		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite um nome:");
			vetor[i] = entrada.next();
			
			System.out.println("Deseja continuar? s/n");
			char opcao = entrada.next().charAt(0);
			
			if (opcao == 'n') {
				break;
			}
		}

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == null)
				break;
			System.out.println(vetor[i]);
		}

		entrada.close();
	}
}
