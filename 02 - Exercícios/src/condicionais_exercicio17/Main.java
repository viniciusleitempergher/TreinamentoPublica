package condicionais_exercicio17;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o dia de nascimento");
		int dia = entrada.nextInt();
		
		System.out.println("Informe o mês de nascimento");
		int mes = entrada.nextInt();

		entrada.close();
		
		switch (mes) {
		case 1:
			if (dia <= 20) {
				System.out.println("Capricórnio!");
			} else {
				System.out.println("Aquário!");
			}
			break;
		case 2:
			if (dia <= 18) {
				System.out.println("Aquário!");
			} else {
				System.out.println("Peixes");
			}
			break;
		case 3:
			if (dia <= 20) {
				System.out.println("Peixes!");
			} else {
				System.out.println("Áries");
			}
			break;
		case 4:
			if (dia <= 20) {
				System.out.println("Áries");
			} else {
				System.out.println("Touro");
			}
			break;
		case 5:
			if (dia <= 20) {
				System.out.println("Touro");
			} else {
				System.out.println("Gêmeos");
			}
			break;
		case 6:
			if (dia <= 20) {
				System.out.println("Gêmeos");
			} else {
				System.out.println("Câncer");
			}
			break;
		case 7:
			if (dia <= 22) {
				System.out.println("Câncer");
			} else {
				System.out.println("Leão");
			}
			break;
		case 8:
			if (dia <= 22) {
				System.out.println("Leão");
			} else {
				System.out.println("Virgem");
			}
			break;
		case 9:
			if (dia <= 22) {
				System.out.println("Virgem");
			} else {
				System.out.println("Libra");
			}
			break;
		case 10:
			if (dia <= 22) {
				System.out.println("Libra");
			} else {
				System.out.println("Escorpião");
			}
			break;
		case 11:
			if (dia <= 23) {
				System.out.println("Escorpião");
			} else {
				System.out.println("Sagitário");
			}
			break;
		case 12:
			if (dia <= 21) {
				System.out.println("Sagitário");
			} else {
				System.out.println("Capricórnio");
			}
		}
	}
}
