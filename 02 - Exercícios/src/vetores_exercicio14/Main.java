package vetores_exercicio14;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[][] perguntas = {
				{"De quem � a famosa frase \"Penso, logo existo\"?", "Plat�o", "Galileu", "Descartes", "S�crates", "3"},
				{"De onde � a inven��o do chuveiro el�trico?", "Fran�a", "Inglaterra", "Brasil", "Austr�lia", "3"},
				{"Qual o menor e o maior pa�s do mundo?", "Vaticano e R�ssia", "Nauru e China", "M�naco e Canad�", "Malta e China", "1"},
				{"Quais os pa�ses que t�m a maior e a menor expectativa de vida do mundo?", "Jap�o e Serra Leoa", "Austr�lia e afeganist�o", "Brasil e Congo", "EUA e Angola", "1"},
				{"Qual o n�mero m�nimo de jogadores numa partida de futebol?", "10", "11", "8", "7", "4"},
				{"Quanto tempo a luz do Sol demora para chegar � Terra?", "9 minutos", "3 horas", "8 minutos", "1 dia", "3"},
				{"Qual a montanha mais alta do Brasil?", "Pico da Neblina", "Pico Paran�", "Monte Roraima", "Pico da Bandeira", "1"},
				{"Em qual local da �sia o portugu�s � l�ngua oficial?", "�ndia", "Filipinas", "Macau", "Mo�ambique", "3"},
				{"Qual o maior animal terrestre?", "Baleia Azul", "Elefante Africano", "Girafa", "Dinossauro", "2"},
				{"Quem foi o primeiro homem a pisar na Lua? Em que ano aconteceu?", "Yuri Gagarin, em 1961", "Charles Conrad, em 1969", "Charles Duke, em 1971", "Neil Armstrong, em 1969", "4"},
				{"As pessoas de qual tipo sangu�neo s�o consideradas doadores universais?", "Tipo A", "Tipo B", "Tipo O", "Tipo ABO", "3"},
				{"Quais s�o os cromossomos que determinam o sexo masculino?", "Os V", "Os Y", "Os X", "Os W", "2"},
		};
		
		Scanner entrada = new Scanner(System.in);
		
		String[][] scoreboard = new String[30][2];
		
		while (true) {
			int posicaoSave = 0;
			
			System.out.println("Digite seu nome:");
			String nome = entrada.nextLine();
			
			for (int i = 0; i < scoreboard.length; i++) {
				if (scoreboard[i][0] == null) {
					posicaoSave = i;
				}
			}
			
			Random random = new Random();
			
			int[] posicaoPerguntas = new int[6];
			
			for (int i = 0; i < posicaoPerguntas.length; i++) {
				posicaoPerguntas[i] = random.nextInt(12);
				for (int l = 0; l < posicaoPerguntas.length; l++) {
					if (posicaoPerguntas[l] == posicaoPerguntas[i] && l != i) {
						i--;
						break;
					}
				}
			}
			
			int acertos = 0;
			
			for (int posicao : posicaoPerguntas) {
				System.out.println("\n" + perguntas[posicao][0]);
				System.out.println("Escolha uma alternativa:\n");
				for (int i = 1; i <= 4; i++) {
					System.out.println(i + " - " + perguntas[posicao][i]);
				}
				
				System.out.println("\nDigite o n�mero");
				int respostaUsuario = Integer.parseInt(entrada.nextLine());
				
				if (respostaUsuario == Integer.parseInt(perguntas[posicao][5])) {
					acertos++;
				}
			}
			
			scoreboard[posicaoSave][0] = nome;
			scoreboard[posicaoSave][1] = acertos + "";
			
			System.out.println("Deseja jogar novamente? (s/n)");
			char opcao = entrada.nextLine().charAt(0);
			if (opcao == 'n') break;
		}
		System.out.println("\nScoreboard:\n");
		for (String[] pessoa : scoreboard) {
			if (pessoa[0] == null) continue;
			System.out.println(pessoa[0]);
			System.out.println(pessoa[1]);
			System.out.println();
		}
		
		entrada.close();
	}
}
