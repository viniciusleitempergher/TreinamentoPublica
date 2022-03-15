package exercicio05;

public class Usuario {
	private String login, senha;
	private boolean admin;
	
	public Usuario(String login, String senha, boolean admin) {
		super();
		this.login = login;
		this.senha = senha;
		this.admin = admin;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
