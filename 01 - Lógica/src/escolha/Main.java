package escolha;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Variável para obter a cidade
		String cidade = JOptionPane.showInputDialog("Digite a cidade: ");

		// Escolha
		switch (cidade.toLowerCase()) {
		case "blumenau":
			JOptionPane.showMessageDialog(null, "Cidade onde ocorre a Oktoberfest!");
			break;
		case "timbó":
			JOptionPane.showMessageDialog(null, "Você é meu vizinho!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Não conheço essa cidade");
			break;
		}
		
		// Switch Statement (JDK 14+)
		switch (cidade) {
		case "blumenau", "florianópolis", "timbó", "brusque" -> JOptionPane.showMessageDialog(null, "SC");
		case "curitiba", "londrina" -> JOptionPane.showMessageDialog(null, "PR");
		default -> JOptionPane.showMessageDialog(null, "Cidade não encontrada!");
		}
	}

}
