package strings_exercicio2;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String verbo = JOptionPane.showInputDialog("Informe um verbo que termina com \"ar\":");
		
		if (!verbo.endsWith("ar")) {
			JOptionPane.showMessageDialog(null, "Esse verbo N�O termina com \"ar\"!");
			System.exit(0);
		}
		
		String verboDesconjugado = verbo.substring(0, verbo.length() - 2);
		
		JOptionPane.showMessageDialog(null, 
				"Eu " + verboDesconjugado + "o\n"
				+ "Tu " + verboDesconjugado + "as\n"
				+ "Ele " + verboDesconjugado + "a\n"
				+ "N�s " + verboDesconjugado + "amos\n"
				+ "V�s " + verboDesconjugado + "ais\n"
				+ "Eles " + verboDesconjugado + "am\n"
				);
	}
}
