package strings_exercicio1;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String palavra = JOptionPane.showInputDialog("Digite uma palavra/frase:");

		String vogais = "aeiou";
		String consoantes = "bcdfghjklmnpqrstvxywz";
		
		int nVogais = 0;
		int nConsoantes = 0;
		
		letrasFrase: for (char c : palavra.toCharArray()) {
			for (char vogal : vogais.toCharArray()) {
				if (c == vogal) {
					nVogais++;
					continue letrasFrase;
				}
			}
			for (char consoante : consoantes.toCharArray()) {
				if (c == consoante) {
					nConsoantes++;
					break;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "A palavra contém:\n"
				+ nVogais + " vogais e "
				+ nConsoantes + " consoantes.");
	}
}
