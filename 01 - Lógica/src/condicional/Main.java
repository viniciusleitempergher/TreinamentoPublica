package condicional;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Scanner
		Scanner receber = new Scanner(System.in);
		
		// Vari�vel
		int idade = receber.nextInt();
		
		// Remover o objeto receber
		receber.close();
		
		// Condicional
		if (idade >= 18) {
			System.out.println("Maior de idade");
		} else {
			System.out.println("Menor de idade");
		}
		
		// Operador Tern�rio
		System.out.println(idade >= 18 ? "Maior de idade" : "Menor de idade");
		
		/*
		 
		 > Maior
		 < Menor
		 >= Maior ou igual
		 <= Menor ou igual
		 == Igual
		 != Diferente
		 
		 */
	}

}
