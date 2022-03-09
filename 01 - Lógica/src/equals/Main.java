package equals;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		// Obter nomes
		String nome1 = JOptionPane.showInputDialog("1º nome");
		String nome2 = JOptionPane.showInputDialog("2º nome");
		
		// Comparativo
		if (nome1.equals(nome2)) {
			JOptionPane.showMessageDialog(null, "São iguais");
		} else {
			JOptionPane.showMessageDialog(null, "São diferentes");
		}
		
	}
}
