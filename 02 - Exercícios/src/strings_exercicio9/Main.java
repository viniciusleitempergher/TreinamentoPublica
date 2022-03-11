package strings_exercicio9;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String[] numerosString = JOptionPane.showInputDialog("Digite os números, separados por vírgula:").split(",");
		
		double soma = 0;
		for (String s : numerosString) {
			soma += Integer.parseInt(s);
		}
		
		JOptionPane.showMessageDialog(null, "Números:" 
				+ numerosString + "\n"
				+ "Soma: " + soma);
	}
}
