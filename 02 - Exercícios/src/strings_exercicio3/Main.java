package strings_exercicio3;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String palavra = JOptionPane.showInputDialog("Digite uma palavra");
		
		String metadeInicial = palavra.substring(0, (int) Math.ceil((double) palavra.length() / 2));
		String metadeFinal;
		
		if (palavra.length() % 2 == 0) {
			metadeFinal = palavra.substring(metadeInicial.length(), palavra.length());
		} else {
			metadeFinal = palavra.substring(metadeInicial.length() - 1, palavra.length());
		}
		
		if (inverterString(metadeFinal).equals(metadeInicial)) 
			JOptionPane.showMessageDialog(null, "� um pal�ndromo!");
		else
			JOptionPane.showMessageDialog(null, "N�o � um pal�ndromo '-'");
	}
	
	static String inverterString(String string) {
		String invertida = "";

		for (int i = string.length() - 1; i >= 0; i--) {
			invertida += string.charAt(i);
		}
		
		return invertida;
	}
}
