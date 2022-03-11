package strings_exercicio6;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String email = JOptionPane.showInputDialog("Digite um email:");
		
		String caracteresEspeciais = "!#$%&'()*+,/:;<=>?[]^`{|}";
		
		boolean emailValido = true;
		
		if (!email.contains("@")) {
			
		} else {

			String[] split = email.split("@");
			if (split.length > 2) {
				emailValido = false;
			} else {
				if (split[0].length() < 1 || split[1].length() < 2) {
					emailValido = false;
				}
			}
		}
		
		for (char c : email.toCharArray()) {
			if (Character.isWhitespace(c)) {
				emailValido = false;
			}
			if (caracteresEspeciais.contains(c + "")) {
				emailValido = false;
			}			
		}
		
		if (emailValido) {
			JOptionPane.showMessageDialog(null, "Email válido!");
		} else {
			JOptionPane.showMessageDialog(null, "Email inválido!");
		}
	}
}
