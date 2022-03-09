package vetores_exercicio09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static boolean ganhou = false;
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] listaPalavras = {"estudar", "comer", "jogar", "trabalhar", "programar", "correr", "pessoa",
				"alfabeto", "corrida"};
		
		Random random = new Random();
		String palavraSecreta = listaPalavras[random.nextInt(9)];
		
		int vidas = 7;
		List<Character> letrasTentadas = new ArrayList<>();

		System.out.println("Jogo da forca!");
		while (vidas > 0) {			
			imprimeForca(palavraSecreta, letrasTentadas);
			if (ganhou)
				ganhaJogo(palavraSecreta, vidas);
			
			System.out.println("Vidas restantes: " + vidas);
			System.out.println("Letras tentadas: \n" + letrasTentadas);
			
			
			System.out.println("Tente uma letra:");
			char letra = entrada.next().toLowerCase().charAt(0);

			if (letrasTentadas.contains(letra)) {
				System.out.println("Voc� j� tentou essa letra!");
				continue;
			}
			
			boolean acertou = false;
			for (char c : palavraSecreta.toCharArray()) {
				if (c == letra) {
					System.out.println("Voc� acertou uma letra!");
					letrasTentadas.add(letra);
					acertou = true;
					break;
				}
			}
			
			if (!acertou) {
				System.out.println("Voc� errou :C");
				vidas--;
				letrasTentadas.add(letra);
			}
		}

		entrada.close();
		
		System.out.println("Infelizmente voc� perdeu :C");
		System.out.println("A palavra era " + palavraSecreta);
	}

	static void imprimeForca(String palavraSecreta, List<Character> letrasTentadas) {
		ganhou = true;
		for (int i = 0; i < palavraSecreta.length(); i++) {
			boolean achouLetra = false;
			for (char c : letrasTentadas) {
				if (c == palavraSecreta.charAt(i)) {
					achouLetra = true;
					break;
				}
			}
			if (achouLetra) {
				System.out.print(palavraSecreta.charAt(i));
			} else {
				System.out.print("_");
				ganhou = false;
			}
		}
		System.out.println();
	}
	
	static void ganhaJogo(String palavraSecreta, int vidas) {
		System.out.println("-------------------------");
		System.out.println("Parab�ns!!!");
		System.out.println("-------------------------");
		System.out.println("Voc� ganhou o jogo da forca!");
		System.out.println("A palavra era: " + palavraSecreta);
		System.out.println("Voc� finalizou com " + vidas + " vidas.");
		System.exit(0);
	}
}
