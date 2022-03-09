package escolha;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Vari�vel para obter a cidade
		String cidade = JOptionPane.showInputDialog("Digite a cidade: ");

		// Escolha
		switch (cidade.toLowerCase()) {
		case "blumenau":
			JOptionPane.showMessageDialog(null, "Cidade onde ocorre a Oktoberfest!");
			break;
		case "timb�":
			JOptionPane.showMessageDialog(null, "Voc� � meu vizinho!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "N�o conhe�o essa cidade");
			break;
		}
		
		// Switch Statement (JDK 14+)
		switch (cidade) {
		case "blumenau", "florian�polis", "timb�", "brusque" -> JOptionPane.showMessageDialog(null, "SC");
		case "curitiba", "londrina" -> JOptionPane.showMessageDialog(null, "PR");
		default -> JOptionPane.showMessageDialog(null, "Cidade n�o encontrada!");
		}
	}

}
