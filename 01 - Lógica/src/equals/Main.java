package equals;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		// Obter nomes
		String nome1 = JOptionPane.showInputDialog("1� nome");
		String nome2 = JOptionPane.showInputDialog("2� nome");
		
		// Comparativo
		if (nome1.equals(nome2)) {
			JOptionPane.showMessageDialog(null, "S�o iguais");
		} else {
			JOptionPane.showMessageDialog(null, "S�o diferentes");
		}
		
	}
}
