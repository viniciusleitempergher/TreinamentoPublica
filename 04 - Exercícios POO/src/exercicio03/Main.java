package exercicio03;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		String[] opcoes = {
				"Login",
                "Cadastro",
                "Sair"
                };
		
		infinito: while (true) {
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma op��o:",
					"Sistema Banc�rio",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			switch (opcao) {
			case 0:
				String login = JOptionPane.showInputDialog("Digite o login:");
				String senha = JOptionPane.showInputDialog("Digite a senha:");
				
				int indiceUsuarioLogado = Autenticacao.logar(login, senha);
				
				if (indiceUsuarioLogado == -1) {
					JOptionPane.showMessageDialog(null, "Informa��es incorretas!");
					break;
				}
				
				new App(indiceUsuarioLogado).iniciar();
				break;
			case 1:
				login = JOptionPane.showInputDialog("Digite o novo login:");
				senha = JOptionPane.showInputDialog("Digite uma nova senha:");
				
				if (!senha.equals(JOptionPane.showInputDialog("Repita a senha"))) {
					JOptionPane.showMessageDialog(null, "Senhas diferentes!");
					break;
				}
				
				Autenticacao.criar(login, senha);
				indiceUsuarioLogado = Autenticacao.logar(login, senha);
				
				new App(indiceUsuarioLogado).iniciar();
				break;
			case 2:
				break infinito;
			}
		}
	}
}
