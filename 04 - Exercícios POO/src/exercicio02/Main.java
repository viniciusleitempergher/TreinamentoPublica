package exercicio02;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar Aluno",
	                "Cadastrar Prova",
	                "Cadastrar Nota",
	                "Selecionar Aluno",
	                "Alterar Aluno",
	                "Alterar Prova",
	                "Alterar Nota",
	                "Remover Aluno",
	                "Remover Prova",
	                "Remover Nota",
	                "Sair"
	                };
			
			int opcao = JOptionPane.showOptionDialog(null,
				"Escolha uma opção:",
				"Sistema de Alunos",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]
			);
			
			switch (opcao) {
			case 0:
				CRUD.cadastrarAluno();
				break;
			case 1:
				CRUD.cadastrarProva();
				break;
			case 2:
				CRUD.cadastrarNota();
				break;
			case 3:
				CRUD.pesquisarAluno();
				break;
			case 4:
				CRUD.alterarAluno();
				break;
			case 5:
				CRUD.alterarProva();
				break;
			case 6:
				CRUD.alterarNota();
				break;
			case 7:
				CRUD.removerAluno();
				break;
			case 8:
				CRUD.removerProva();
				break;
			case 9:
				CRUD.removerNota();
				break;
			case 10:
				break infinito;
			}
		}
	}
}
