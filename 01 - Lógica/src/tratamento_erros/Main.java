package tratamento_erros;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		boolean valida = false;
		
		do {
			try {
				int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um n�mero:"));
				valida = true;
			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, "Erro: " + err.getMessage());
			}
		} while (valida == false);
		
	}
}
