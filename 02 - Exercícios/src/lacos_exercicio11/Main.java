package lacos_exercicio11;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Random random = new Random();
		
		int numeroSorteado = random.nextInt(100) + 1;
		
		int tentativas = 0;
		
		System.out.println("Tente acertar o n�mero:");
		while (true) {
			int numeroChutado = entrada.nextInt();
			tentativas++;
			
			if (numeroChutado == numeroSorteado) {
				System.out.println("Voc� acertou, parab�ns!");
				System.out.println("Voc� acertou em " + tentativas + " tentativas!");
				break;
			} else if ((numeroChutado < numeroSorteado && numeroChutado + 10 > numeroSorteado) || 
					(numeroChutado > numeroSorteado && numeroChutado - 10 < numeroSorteado)) {
				System.out.println("Voc� errou, por�m passou perto!");
			} else {
				System.out.println("Voc� errou e passou longe de acertar!");
			}
			System.out.println("Tente novamente:");
		}
		
		entrada.close();
	}
}
