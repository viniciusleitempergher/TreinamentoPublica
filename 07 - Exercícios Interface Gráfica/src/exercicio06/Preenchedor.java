package exercicio06;

public class Preenchedor {
	public static void cadastrarMatematica() {
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 5*8?", 
				new String[] {"40", "45", "35"}, 0));
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 5*9?", 
				new String[] {"40", "45", "35"}, 1));
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 5*10?", 
				new String[] {"40", "50", "35"}, 1));
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 5*10*(-5)?", 
				new String[] {"-250", "250", "-150"}, 0));
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 3^3?", 
				new String[] {"40", "28", "27"}, 2));
		Dados.perguntasMatematica.add(new Pergunta("Quanto � 6*8?", 
				new String[] {"48", "45", "38"}, 0));
	}
	
	public static void cadastrarPortugues() {
		Dados.perguntasPortugues.add(new Pergunta("Qual � o plural de alem�o?", 
				new String[] {"Alem�os", "Alem�es", "Alem�es"}, 2));
		Dados.perguntasPortugues.add(new Pergunta("Qual � o feminino de cavaleiro?", 
				new String[] {"Cavaleira", "Princesa", "Amazona"}, 2));
		Dados.perguntasPortugues.add(new Pergunta("Quantas letras tem o alfabeto?", 
				new String[] {"27", "26", "24"}, 1));
		Dados.perguntasPortugues.add(new Pergunta("Not�vago � aquele que...", 
				new String[] {"faz anota��es", "tem h�bitos noturnos", "monta autom�veis"}, 1));
		Dados.perguntasPortugues.add(new Pergunta("Borracho � o mesmo que...", 
				new String[] {"b�bado", "borracha", "batom"}, 0));
		Dados.perguntasPortugues.add(new Pergunta("Barriga-verde � um gent�lico para qual estado brasileiro?", 
				new String[] {"Santa Catarina", "Paran�", "Acre"}, 0));
	}
}
