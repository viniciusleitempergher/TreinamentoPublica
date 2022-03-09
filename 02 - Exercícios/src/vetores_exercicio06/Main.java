package vetores_exercicio06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[][] jogoDaVelha = new String[3][3];

		imprimeJogo(jogoDaVelha, false, 0);

		boolean xJoga = true;

		while (true) {
			verificaSeVenceu(jogoDaVelha);

			if (xJoga) {
				System.out.println("X joga!");
			} else {
				System.out.println("O joga!");
			}
			System.out.println("Informe o número que deseja jogar: ");
			int opcao = entrada.nextInt();

			imprimeJogo(jogoDaVelha, xJoga, opcao);

			xJoga = !xJoga;
		}
	}

	static void imprimeJogo(String[][] matrizJogo, boolean xJoga, int opcao) {
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int l = 0; l < 3; l++) {
				if (matrizJogo[i][l] == null) {
					if (opcao == count) {
						matrizJogo[i][l] = (xJoga) ? "X" : "O";
						System.out.print(matrizJogo[i][l] + " ");
					} else {
						System.out.print(count + " ");
					}
				} else {
					System.out.print(matrizJogo[i][l] + " ");
				}
				if (count++ % 3 == 0)
					System.out.println();
			}
		}
	}

	static void verificaSeVenceu(String[][] matrizJogo) {
		for (int linha = 0; linha < 3; linha++) {
			if (matrizJogo[linha][0] == matrizJogo[linha][1] && matrizJogo[linha][1] == matrizJogo[linha][2]) {
				if (matrizJogo[linha][0] == null) continue;
				System.out.println("O jogador " + matrizJogo[linha][0] + " venceu!");
				System.exit(0);
			}
		}
		for (int coluna = 0; coluna < 3; coluna++) {
			if (matrizJogo[0][coluna] == matrizJogo[1][coluna] && matrizJogo[1][coluna] == matrizJogo[2][coluna]) {
				if (matrizJogo[0][coluna] == null) continue;
				System.out.println("O jogador " + matrizJogo[0][coluna] + " venceu!");
				System.exit(0);
			}
		}
		if (matrizJogo[0][0] == matrizJogo[1][1] && matrizJogo[1][1] == matrizJogo[2][2]) {
			if (matrizJogo[0][0] != null) {
				System.out.println("O jogador " + matrizJogo[0][0] + " venceu!");
				System.exit(0);
			}
		}
		if (matrizJogo[2][0] == matrizJogo[1][1] && matrizJogo[1][1] == matrizJogo[1][2]) {
			if (matrizJogo[2][0] != null) {
				System.out.println("O jogador " + matrizJogo[0][0] + " venceu!");
				System.exit(0);
			}
		}
	}
}
