package condicionais_exercicio01;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 1"));
		double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 2"));
		double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 3"));
		
		double media = (nota1 + nota2 + nota3) / 3;
		
		JOptionPane.showMessageDialog(null, "Sua média foi: " + media);
	}
}
