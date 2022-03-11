package strings_exercicio4;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String frase = JOptionPane.showInputDialog("Informe uma frase:");
		
		int maiusculas = 0;
		int minusculas = 0;
		int espacos = 0;
		int numeros = 0;
		
		for (char c : frase.toCharArray()) {
			if (Character.isUpperCase(c)) maiusculas++;
			if (Character.isLowerCase(c)) minusculas++;
			if (Character.isDigit(c)) numeros++;
			if (Character.isWhitespace(c)) espacos++;
		}
		
		JOptionPane.showMessageDialog(null, "N�mero de mai�sculas: " + maiusculas + "\n"
				+ "N�mero de min�sculas: " + minusculas + "\n"
				+ "N�mero de espa�os: " + espacos + "\n"
				+ "N�mero de n�meros: " + numeros + "\n"
				);
		
	}
}
