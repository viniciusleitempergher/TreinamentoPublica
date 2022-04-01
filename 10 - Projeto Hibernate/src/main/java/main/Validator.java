package main;

public class Validator {
	public static double validarDouble(String txt) {
		double numero;
		try {
			numero = Double.parseDouble(txt);
		} catch (Exception e) {
			return -1;
		}
		
		return numero;
	}
}
