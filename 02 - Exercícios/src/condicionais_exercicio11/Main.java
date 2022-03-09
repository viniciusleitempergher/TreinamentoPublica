package condicionais_exercicio11;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o valor da compra:");
		double valor = entrada.nextDouble();
		
		entrada.close();
		
		if (valor >= 200) {
			System.out.println("Sua compra terá desconto de 20%");
			System.out.println("Valor total: R$" + valor * 0.8);
		} else {
			System.out.println("Sua compra não terá desconto!");
			System.out.println("Valor total: R$" + valor);
		}
	}
}
