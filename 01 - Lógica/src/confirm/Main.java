package confirm;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		// ConfirmDialog
		int acao = JOptionPane.showConfirmDialog(null, "Escolha uma op��o");
		
		// Retornar a a��o
		JOptionPane.showMessageDialog(null, acao);
	}
}
