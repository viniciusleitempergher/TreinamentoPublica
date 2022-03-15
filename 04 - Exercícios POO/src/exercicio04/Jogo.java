package exercicio04;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Jogo {
	ArrayList<Pergunta> perguntasSelecionadas;
	ArrayList<Pergunta> perguntas;
	
	public Jogo() {
		perguntasSelecionadas = new ArrayList<>();
		perguntas = PerguntasPreDefinidas.retornaPerguntas();
	}
	
	void selecionarPerguntas() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int iPerguntaSelecionada = random.nextInt(10);
			
			if (perguntasSelecionadas.contains(perguntas.get(iPerguntaSelecionada))) {
				i--;
				continue;
			}
			
			perguntasSelecionadas.add(perguntas.get(iPerguntaSelecionada));
		}
	}
	
	void iniciar() {
		selecionarPerguntas();
		
		int acertos = 0;
		
		for (int i = 0; i < perguntasSelecionadas.size(); i++) {
			Pergunta perguntaAtual = perguntasSelecionadas.get(i);
			
			String exibicaoP = "Pergunta " + (i + 1) + "\n";
			exibicaoP += perguntaAtual.getTexto() + "\n\nAlternativas:\n";
			for (int l = 0; l < 4; l++) {
				exibicaoP += (l + 1) + ") " + perguntaAtual.getAlternativas().get(l) + "\n";
			}
			
			exibicaoP += "\n5) Dica\n6) Pular";
			
			int opcao = Integer.parseInt(
						JOptionPane.showInputDialog(exibicaoP)
					);
			
			if (--opcao == perguntaAtual.getiAlternativaCorreta()) {
				acertos++;
				JOptionPane.showMessageDialog(null, "Você acertou!");
			} else {
				JOptionPane.showMessageDialog(null, "Você errou :C");
			}
		}
		JOptionPane.showMessageDialog(null, "Você acertou " + acertos + " de 5 questões!");
	}
}
