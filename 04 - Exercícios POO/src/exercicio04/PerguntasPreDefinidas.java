package exercicio04;

import java.util.ArrayList;

public class PerguntasPreDefinidas {
	private static ArrayList<Pergunta> perguntasPreDefinidas = new ArrayList<>();
	
	static ArrayList<Pergunta> retornaPerguntas() {
		ArrayList<String> alternativas = new ArrayList<>();
		// Pergunta 1
		alternativas.add("3,14");
		alternativas.add("1,42");
		alternativas.add("9,14");
		alternativas.add("9,85");

		perguntasPreDefinidas.add(new Pergunta("Quanto é raíz de pi²? PI = 3,14",
				"Toda raiz de um número ao quadrado equivale a...", new ArrayList<>(alternativas), 0));
		alternativas.clear();
		
		// Pergunta 2
		alternativas.add("5");
		alternativas.add("-1");
		alternativas.add("-19");
		alternativas.add("1");

		perguntasPreDefinidas.add(new Pergunta("Quanto é 20 - 21",
				"Algo perto de 0", new ArrayList<>(alternativas), 1));
		alternativas.clear();
		
		// Pergunta 3
		alternativas.add("11");
		alternativas.add("15");
		alternativas.add("21");
		alternativas.add("10");

		perguntasPreDefinidas.add(new Pergunta("Quanto é 2 + 9",
				"Não é 10!", new ArrayList<>(alternativas), 0));
		alternativas.clear();
		
		// Pergunta 4
		alternativas.add("China");
		alternativas.add("EUA");
		alternativas.add("Brasil");
		alternativas.add("França");

		perguntasPreDefinidas.add(new Pergunta("Onde fica Paris?",
				"Fica na europa...", new ArrayList<>(alternativas), 3));
		alternativas.clear();
		
		// Pergunta 5
		alternativas.add("Uma letra");
		alternativas.add("Um número");
		alternativas.add("Um ovo");
		alternativas.add("Um buraco");
		
		perguntasPreDefinidas.add(new Pergunta("'O'\nO caractere entre aspas é:",
				"'0' <- este é um zero!", new ArrayList<>(alternativas), 0));
		alternativas.clear();
		
		// Pergunta 6
		alternativas.add("200");
		alternativas.add("-200");
		alternativas.add("400");
		alternativas.add("-400");
		
		perguntasPreDefinidas.add(new Pergunta("Qual o resultado da equação: -2 * 10²", 
				"É negativo!", new ArrayList<>(alternativas), 1));
		alternativas.clear();
		
		// Pergunta 7
		alternativas.add("Bolacha");
		alternativas.add("Biscoito");
		alternativas.add("Cookie");
		alternativas.add("Biscuit");
		
		perguntasPreDefinidas.add(new Pergunta("Qual o nome correto?",
				"Não é biscoito!", new ArrayList<>(alternativas), 0));
		alternativas.clear();
		
		// Pergunta 8
		alternativas.add("Texas");
		alternativas.add("Califórnia");
		alternativas.add("Washington");
		alternativas.add("Nova York");
		
		perguntasPreDefinidas.add(new Pergunta("Qual a capital dos EUA?", 
				"É vizinha a Maryland e Virgínia.", new ArrayList<>(alternativas), 2));
		alternativas.clear();
		
		// Pergunta 9
		alternativas.add("7 Litros");
		alternativas.add("4 Litros");
		alternativas.add("2 Litros");
		alternativas.add("5 Litros");
		
		perguntasPreDefinidas.add(new Pergunta("Quantos litros de sangue um adulto tem no sangue, em média?",
				"Pesquise no google.", new ArrayList<>(alternativas), 3));
		alternativas.clear();
		
		// Pergunta 10
		alternativas.add("Florianópolis");
		alternativas.add("Balneário Camboriú");
		alternativas.add("Rio de Janeiro");
		alternativas.add("São Paulo");
		
		perguntasPreDefinidas.add(new Pergunta("Onde fica localizado o maior prédio do Brasil?", 
				"Pesquise no google.", new ArrayList<>(alternativas), 1));
		alternativas.clear();
		
		alternativas.add("test");
		
		return perguntasPreDefinidas;
	}
}
