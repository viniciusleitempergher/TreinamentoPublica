package vetor;

public class Main {

	public static void main(String[] args) {
		
		// Vetor
		String[] cores = {"Vermelho", "Azul", "Preto", "Amarelo", "Rosa"};
		
		// Listar cores
		for (int indice = 0; indice < cores.length; indice++) {
			System.out.println(cores[indice]);
		}
		
		// Vetor 2
		String[] nomes = new String[3];
		
		// Cadastrar nomes
		nomes[0] = "Alice";
		nomes[1] = "Caio";
		nomes[2] = "Vinícius";
		
		// ForEach
		for (String n : nomes) {
			System.out.println(n);
		}
	}

}
