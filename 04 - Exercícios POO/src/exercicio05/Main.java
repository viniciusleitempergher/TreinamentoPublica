package exercicio05;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	static Usuario usuarioLogado;
	
	public static void main(String[] args) throws IOException {
		infinito: while (true) {
			String[] opcoes = {
					"Login",
	                "Sair"
	                };
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema",
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
				
				Usuario usuario = Leitor.procurarUsuario(login, senha);
				
				if (usuario == null) {
					JOptionPane.showMessageDialog(null, "Informações incorretas!");
					break;
				}
				
				JOptionPane.showMessageDialog(null, "Bem vindo, " + usuario.getLogin());
				usuarioLogado = usuario;
				
				if (usuarioLogado.isAdmin()) {
					GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
					gerenciadorUsuarios.iniciar();
				} else {
					App app = new App();
					app.iniciar();
				}
				
				break;
			case 1:
				break infinito;
			}
		}
	}
}
