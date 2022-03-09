package lacos_exercicio10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String pares = "";
		String impares = "";
		String positivos = "";
		String negativos = "";

		while (true) {
			System.out.println("Digite um número: (0 para parar)");
			int numero = entrada.nextInt();

			if (numero == 0)
				break;

			if (numero > 0) positivos += numero + ", ";
			
			if (numero < 0) negativos += numero + ", ";
			
			if (numero % 2 == 0)
				pares += numero + ", ";
			else
				impares += numero + ", ";
		}
		entrada.close();
		
		
		if (pares.length() > 0) pares = pares.substring(0, pares.length() - 2);
		if (impares.length() > 0) impares = impares.substring(0, impares.length() - 2);
		if (negativos.length() > 0) negativos = negativos.substring(0, negativos.length() - 2);
		if (positivos.length() > 0) positivos = positivos.substring(0, positivos.length() - 2);
		
		System.out.println("Números pares: " + ((pares.length() > 0) ? pares : "nenhum"));
		System.out.println("Números ímpares: " + ((impares.length() > 0) ? impares : "nenhum"));
		System.out.println("Números negativos: " + ((negativos.length() > 0) ? negativos : "nenhum"));
		System.out.println("Números positivos: " + ((positivos.length() > 0) ? positivos : "nenhum"));
	}
}
