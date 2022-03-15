package exercicio03;

import javax.swing.JOptionPane;

public class Usuario {
	private String login, senha;
	private Conta conta;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public void criarConta() {
		conta = new Conta(
				JOptionPane.showInputDialog("Informe a agência:"),
				JOptionPane.showInputDialog("Informe a conta corrente:"),
				0
			);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta contas) {
		this.conta = contas;
	}
}
