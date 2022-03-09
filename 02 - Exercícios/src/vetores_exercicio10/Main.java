package vetores_exercicio10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = new String[10];
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Informe um valor:");
			vetor[i] = entrada.next();
		}
		
		entrada.close();
		
		String[] vetorInvertido = new String[10];
		int count = 0;
		for (int i = 9; i >= 0; i--) {
			vetorInvertido[count++] = vetor[i];
		}
		
		System.out.println("Vetor invertido:");
		for (String item : vetorInvertido) {
			System.out.print(item + " ");
		}
	}
}
