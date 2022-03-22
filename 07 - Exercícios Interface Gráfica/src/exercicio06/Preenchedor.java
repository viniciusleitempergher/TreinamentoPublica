package exercicio06;

public class Preenchedor {
	public static void cadastrarMatematica() {
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 5*8?", 
				new String[] {"40", "45", "35"}, 0));
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 5*9?", 
				new String[] {"40", "45", "35"}, 1));
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 5*10?", 
				new String[] {"40", "50", "35"}, 1));
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 5*10*(-5)?", 
				new String[] {"-250", "250", "-150"}, 0));
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 3^3?", 
				new String[] {"40", "28", "27"}, 2));
		Dados.perguntasMatematica.add(new Pergunta("Quanto é 6*8?", 
				new String[] {"48", "45", "38"}, 0));
	}
	
	public static void cadastrarPortugues() {
		Dados.perguntasPortugues.add(new Pergunta("Qual é o plural de alemão?", 
				new String[] {"Alemãos", "Alemões", "Alemães"}, 2));
		Dados.perguntasPortugues.add(new Pergunta("Qual é o feminino de cavaleiro?", 
				new String[] {"Cavaleira", "Princesa", "Amazona"}, 2));
		Dados.perguntasPortugues.add(new Pergunta("Quantas letras tem o alfabeto?", 
				new String[] {"27", "26", "24"}, 1));
		Dados.perguntasPortugues.add(new Pergunta("Notívago é aquele que...", 
				new String[] {"faz anotações", "tem hábitos noturnos", "monta automóveis"}, 1));
		Dados.perguntasPortugues.add(new Pergunta("Borracho é o mesmo que...", 
				new String[] {"bêbado", "borracha", "batom"}, 0));
		Dados.perguntasPortugues.add(new Pergunta("Barriga-verde é um gentílico para qual estado brasileiro?", 
				new String[] {"Santa Catarina", "Paraná", "Acre"}, 0));
	}
}
