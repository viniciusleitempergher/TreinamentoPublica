package exercicio05;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciadorUsuarios {
	public void iniciar() throws IOException {
		infinito: while (true) {
			ArrayList<Usuario> usuarios = Leitor.listarUsuarios();
			String[] opcoes = {
					"Cadastrar Usuário",
					"Remover Usuário",
					"Listar Usuários",
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
				boolean admin = 
						(JOptionPane.showConfirmDialog(null, "Deseja cadastrar como admin?") == 0)
						? true
						: false;
				Leitor.gravarUsuario(new Usuario(login, senha, admin));
				JOptionPane.showMessageDialog(null, "Cadastrado!");
				break;
			case 1:
				login = JOptionPane.showInputDialog("Digite o nome de quem deseja remover:");
				Leitor.deletarUsuario(login);
				JOptionPane.showMessageDialog(null, "Removido!");
				break;
			case 2:
				String saidaUsuarios = "";
				for (Usuario u : usuarios) {
					saidaUsuarios += "Nome: " + u.getLogin() + "\nAdmin: "
							+ (u.isAdmin() ? "Sim" : "Não") + "\n\n";
				}
				JOptionPane.showMessageDialog(null, saidaUsuarios);
				break;
			case 3:
				break infinito;
			}
		}
	}
}
