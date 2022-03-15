package exercicio03;

import java.util.ArrayList;

public class Autenticacao {
	static ArrayList<Usuario> usuarios = new ArrayList<>();
	static int indiceUsuarioLogado = -1;
	
	static void criar(String login, String senha) {
		Usuario usuario = new Usuario(login, senha);
		usuario.criarConta();
		usuarios.add(usuario);
	}
	
	static int logar(String login, String senha) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(login)
					&& usuarios.get(i).getSenha().equals(senha)) {
				indiceUsuarioLogado = i;
				break;
			}
		}
		return indiceUsuarioLogado;
	}
	
	static void logout() {
		indiceUsuarioLogado = -1;
	}
}
