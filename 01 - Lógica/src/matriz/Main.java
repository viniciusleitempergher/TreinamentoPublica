package matriz;

public class Main {
	public static void main(String[] args) {
		
		// Matriz
		String[][] dados = {
				{"Alice", "Blumenau"},
				{"Isabella", "S�o Paulo"},
				{"Vin�cius", "Timb�"}
		};
		
		// For
		for (int indice = 0; indice < dados.length; indice++) {
			System.out.println(dados[indice][0]);
			System.out.println(dados[indice][1]);
			System.out.println();
		}
		
		for (String[] d : dados) {
			System.out.println(d[0]);
			System.out.println(d[1]);
			System.out.println();
		}
	}
}
