package arrays_exercicio1;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> nome = new ArrayList<>();
		ArrayList<Integer> idade = new ArrayList<>();
		ArrayList<String> email = new ArrayList<>();
		ArrayList<String> telefone = new ArrayList<>();
		ArrayList<String> cidade = new ArrayList<>();
		
		infinito: while (true) {
			int opcao = -1;
			try {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("Digite uma opção: "
								+ "\n1 - Cadastrar"
								+ "\n2 - Listar"
								+ "\n3 - Pesquisar"
								+ "\n4 - Alterar"
								+ "\n5 - Remover"
								+ "\n6 - Sair")
				);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Você deve digitar um número!");
				continue;
			}
			switch (opcao) {
			case 1:
				
				break;
			case 6:
				break infinito;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
	
}
