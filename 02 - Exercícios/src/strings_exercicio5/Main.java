package strings_exercicio5;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String[] unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
				"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezesete", "dezoito", "dezenove",
				"vinte"};
		String[] dezenas = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
		String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos",
				"oitocentos", "novecentos"};

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número até 1 milhão positivo\nEx: 1"));
		
		if (numero < 0) JOptionPane.showMessageDialog(null, "O número deve ser positivo!");
		if (numero > 1000000) JOptionPane.showMessageDialog(null, "O número deve ser menor ou igual a um milhão!");
		
		String numeroString = numero + "";
		String numeroPorExtenso = "";

		if (numeroString.length() >= 6) {
			numeroPorExtenso += centenas[Integer.parseInt(numeroString.charAt(numeroString.length() - 6) + "")] + " ";
		}
		if (numeroString.length() >= 5) {
			if (numeroString.charAt(numeroString.length() - 5) != '0')
				if (numeroString.length() > 5) numeroPorExtenso += "e ";
				numeroPorExtenso += dezenas[Integer.parseInt(numeroString.charAt(numeroString.length() - 5) + "")] + " ";
		}
		if (numeroString.length() >= 4) {
			if (numeroString.charAt(numeroString.length() - 4) != '0') {
				if (numeroString.length() > 4) numeroPorExtenso += "e ";
				numeroPorExtenso += unidades[Integer.parseInt(numeroString.charAt(numeroString.length() - 4) + "")] + " ";
			}
			numeroPorExtenso += "mil ";
		}
		if (numeroString.length() >= 3) {
			if (numeroString.charAt(numeroString.length() - 3) != '0') {
				if (numeroString.length() > 3) numeroPorExtenso += ", ";
				numeroPorExtenso += centenas[Integer.parseInt(numeroString.charAt(numeroString.length() - 3) + "")] + " ";
			}
		}
		if (numeroString.length() >= 2) {
			if (numeroString.charAt(numeroString.length() - 2) != '0') {
				if (numeroString.length() > 2) numeroPorExtenso += "e ";
				numeroPorExtenso += dezenas[Integer.parseInt(numeroString.charAt(numeroString.length() - 2) + "")] + " ";
			}
		}
		if (numeroString.length() >= 1) {
			if (numeroString.charAt(numeroString.length() - 1) != '0') {
				if (numeroString.length() > 1) numeroPorExtenso += "e ";
				numeroPorExtenso += unidades[Integer.parseInt(numeroString.charAt(numeroString.length() - 1) + "")] + " ";
			}
		}

		if (numeroString.length() == 7) {
			numeroPorExtenso = "um milhão";
		}
		
		if (numero < 21) numeroPorExtenso = unidades[numero];

		JOptionPane.showMessageDialog(null, numeroPorExtenso);
	}
}
