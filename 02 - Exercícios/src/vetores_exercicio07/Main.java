package vetores_exercicio07;

public class Main {
	public static void main(String[] args) {
		int[][] matriz = {
				{ 1, 2, 3, 4, 5},
				{ 1, 2, 3, 4, 5},
				{ 1, 2, 3, 4, 5},
				{ 1, 2, 3, 4, 5},
				{ 1, 2, 3, 4, 5}
		};
		
		System.out.println("Matriz:");
		for (int i = 0; i < matriz.length; i++) {
			for (int l = 0; l < matriz.length; l++) {
				System.out.print(matriz[i][l] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Diagonal principal: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int l = 0; l < matriz[i].length; l++) {
				if (i == l) {
					System.out.print(matriz[i][l]);
				} else {
					System.out.print("~");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("Diagonal secundária: ");
		int count = 0;
		int decCount = 4;
		for (int i = 0; i < matriz.length; i++) {
			for (int l = 0; l < matriz[i].length; l++) {
				if (l == decCount && count == i) {
					System.out.print(matriz[i][l]);
					count++;
					decCount--;
				} else {
					System.out.print("~");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("Soma dos valores:");
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int l = 0; l < matriz.length; l++) {
				soma += matriz[i][l];
			}
		}
		System.out.println("Total: " + soma);
		System.out.println("Média dos valores: " + soma / 25);
		
		System.out.println("Quantidade de valores iguais ou acima da média:");
		count = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int l = 0; l < matriz.length; l++) {
				if (matriz[i][l] >= soma / 25) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
