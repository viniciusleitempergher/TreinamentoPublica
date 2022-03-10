package strings_exercicio2;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String verbo = JOptionPane.showInputDialog("Informe um verbo que termina com \"ar\":");
		
		if (!verbo.endsWith("ar")) {
			JOptionPane.showMessageDialog(null, "Esse verbo NÃO termina com \"ar\"!");
			System.exit(0);
		}
		
		String verboDesconjugado = verbo.substring(0, verbo.length() - 2);
		
		JOptionPane.showMessageDialog(null, 
				"Eu " + verboDesconjugado + "o\n"
				+ "Tu " + verboDesconjugado + "as\n"
				+ "Ele " + verboDesconjugado + "a\n"
				+ "Nós " + verboDesconjugado + "amos\n"
				+ "Vós " + verboDesconjugado + "ais\n"
				+ "Eles " + verboDesconjugado + "am\n"
				);
	}
}
