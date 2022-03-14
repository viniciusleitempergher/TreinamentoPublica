package exercicio02;

public class Aluno {
	private String nome;
	private String dataNascimento;
	private String telefone;
	
	public Aluno(String nome, String dataNascimento, String telefone) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
