package vetores_exercicio05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String[][] pessoas = new String[10][2];
		
		for (int i = 0; i < pessoas.length; i++) {
			System.out.println("Digite um nome:");
			pessoas[i][0] = entrada.next();
			
			System.out.println("Digite a idade:");
			pessoas[i][1] = entrada.next();
			
			System.out.println("Desseja continuar? (s/n)");
			char opcao = entrada.next().charAt(0);
			
			if (opcao == 'n') break;
		}
		
		entrada.close();
		
		for (String[] pessoa : pessoas) {
			if (pessoa[0] == null) break;
			System.out.println("Nome: " + pessoa[0]);
			System.out.println("Idade: " + pessoa[1]);
			System.out.println();
		}
	}
}
