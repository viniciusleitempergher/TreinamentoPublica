package lacos_exercicio11;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Random random = new Random();
		
		int numeroSorteado = random.nextInt(100) + 1;
		
		int tentativas = 0;
		
		System.out.println("Tente acertar o número:");
		while (true) {
			int numeroChutado = entrada.nextInt();
			tentativas++;
			
			if (numeroChutado == numeroSorteado) {
				System.out.println("Você acertou, parabéns!");
				System.out.println("Você acertou em " + tentativas + " tentativas!");
				break;
			} else if ((numeroChutado < numeroSorteado && numeroChutado + 10 > numeroSorteado) || 
					(numeroChutado > numeroSorteado && numeroChutado - 10 < numeroSorteado)) {
				System.out.println("Você errou, porém passou perto!");
			} else {
				System.out.println("Você errou e passou longe de acertar!");
			}
			System.out.println("Tente novamente:");
		}
		
		entrada.close();
	}
}
