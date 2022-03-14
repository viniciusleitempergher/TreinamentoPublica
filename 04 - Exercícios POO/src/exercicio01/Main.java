package exercicio01;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		infinito: while(true) {
			String[] opcoes = {
					"Cadastrar",
	                "Pesquisar",
	                "Alterar",
	                "Remover",
	                "Aniversariantes",
	                "Sair"
	                };
			
			int opcao = JOptionPane.showOptionDialog(null,
				"Escolha uma opção:",
				"Agenda",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]
			);
			
			try {
				switch (opcao) {
					case 0:
						CRUDPessoas.adicionar();
						break;
					case 1:
						CRUDPessoas.pesquisaPessoa(JOptionPane.showInputDialog("Digite o nome da pessoa:"));
						break;
					case 2:
						CRUDPessoas.alterar(JOptionPane.showInputDialog("Digite o nome da pessoa:"));
						break;
					case 3:
						CRUDPessoas.remover(JOptionPane.showInputDialog("Digite o nome da pessoa:"));
						break;
					case 4:
						for (Pessoa pessoa : CRUDPessoas.retornaAniversariantes()) {
							CRUDPessoas.mostraPessoa(pessoa);
						}
						break;
					case 5:
						break infinito;
				}
			} catch (Exception e) {
				
			} 
		}
	}
}
