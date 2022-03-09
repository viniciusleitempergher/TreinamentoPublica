package condicionais_exercicio06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o horário de brasília: ");
		int horario = entrada.nextInt();
		
		System.out.println("Lista de cidades: ");
		System.out.println("1 - Tóquio");
		System.out.println("2 - Nova Iorque");
		System.out.println("3 - Cidade do méxico");
		System.out.println("Digite uma opção:");
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
		
		System.out.println("O horário na cidade escolhida é " + horario);
	}
}