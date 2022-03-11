package strings_exercicio7;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		
		String[] opcoes = {
				"Cadastrar",
				"Filtrar",
				"Finalizar"
		};
		
		infinito: while (true) {
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema de Cadastro",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			switch (opcao) {
			case 0:
				nomes.add(JOptionPane.showInputDialog("Digite o nome"));
				JOptionPane.showMessageDialog(null, "Cadastrado!");
				break;
			case 1:
				String pesquisa = JOptionPane.showInputDialog("Digite o nome a ser pesquisado:");
				
				boolean temAlgum = false;
				
				for (String nome : nomes) {
					if (nome.contains(pesquisa)) {
						JOptionPane.showMessageDialog(null, nome);
						temAlgum = true;
					}
				};
				
				if (!temAlgum) JOptionPane.showMessageDialog(null, "Nenhuma correspondência!");
				
				break;
			case 2:
				break infinito;
			}
		}
	}
}
