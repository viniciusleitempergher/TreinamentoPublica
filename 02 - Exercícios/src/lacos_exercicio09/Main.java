package lacos_exercicio09;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] nomesCandidatos = {"Juçara", "Juliana", "Edward", "José"};
		int[] votosCandidatos = {0, 0, 0, 0};
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Sistema de votação!");
		while (true) {
			System.out.println("1 - " + nomesCandidatos[0]);
			System.out.println("2 - " + nomesCandidatos[1]);
			System.out.println("3 - " + nomesCandidatos[2]);
			System.out.println("4 - " + nomesCandidatos[3]);
			System.out.println("Escolha um número:");
			int opcao = entrada.nextInt();
			
			votosCandidatos[--opcao]++;
			
			System.out.println("Voto computado!");
			
			System.out.println("Deseja continuar a votação? s/n");
			if (entrada.next().charAt(0) == 'n') break;
		}
		
		entrada.close();
				
		int maior = 0;
		for (int i = 0; i < nomesCandidatos.length; i++) {
			if (votosCandidatos[i] > maior) {
				maior = votosCandidatos[i];
			}
		}
		
		String ganhador = "";
		for (int i = 0; i < nomesCandidatos.length; i++) {
			if (votosCandidatos[i] == maior) {
				ganhador += nomesCandidatos[i] + ", ";
			}
		}
		
		ganhador = ganhador.substring(0, ganhador.length() - 2);
		
		double totalVotos = votosCandidatos[0] + votosCandidatos[1] + votosCandidatos[2] + votosCandidatos[3];
		double porcentagem = maior / totalVotos * 100;
		
		System.out.println("O(s) ganhador(es) foi/foram: ");
		System.out.println(ganhador);
		System.out.println("Com " + porcentagem + "% dos votos cada!");
	}
}
