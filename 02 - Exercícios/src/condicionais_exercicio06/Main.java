package condicionais_exercicio06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o hor�rio de bras�lia: ");
		int horario = entrada.nextInt();
		
		System.out.println("Lista de cidades: ");
		System.out.println("1 - T�quio");
		System.out.println("2 - Nova Iorque");
		System.out.println("3 - Cidade do m�xico");
		System.out.println("Digite uma op��o:");
		int opcao = entrada.nextInt();
		
		entrada.close();
		
		switch (opcao) {
		case 1:
			horario += 12;
			break;
		case 2:
			horario -= 2;
			break;
		case 3:
			horario -= 3;
			break;
		}
		
		System.out.println("O hor�rio na cidade escolhida � " + horario);
	}
}