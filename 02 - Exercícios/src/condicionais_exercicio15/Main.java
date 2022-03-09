package condicionais_exercicio15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		List<Integer> numeros = new ArrayList<>();
		
		System.out.println("Digite o primeiro número");
		numeros.add(entrada.nextInt());
		
		System.out.println("Digite o segundo número");
		numeros.add(entrada.nextInt());
		
		System.out.println("Digite o terceiro número");
		numeros.add(entrada.nextInt());
		
		entrada.close();
		
		Collections.sort(numeros);
		Collections.reverse(numeros);
		
		System.out.println("Lista em ordem decrescente: " + numeros);
	}
}
