package condicionais_exercicio08;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Conversor de moedas:");
		System.out.println("1 - Real para Dólar;");
		System.out.println("2 - Dólar para Real;");
		System.out.println("3 - Real para Euro;");
		System.out.println("4 - Euro para Real.");

		System.out.println("Digite a opção:");
		int opcao = entrada.nextInt();
		
		double conversao = 0;
		
		switch (opcao) {
		case 1:
			conversao = 0.2;
			break;
		case 2:
			conversao = 5.08;
			break;
		case 3:
			conversao = 0.18;
			break;
		case 4:
			conversao = 5.52;
			break;
		default:
			System.out.println("Opção inválida.");
			System.exit(0);
		}
		
		System.out.println("Digite a quantidade a ser convertida:");
		double dinheiro = entrada.nextDouble();
		
		entrada.close();
		
		dinheiro *= conversao;
		System.out.println("Quantidade convertida: " + dinheiro);
	}
}
