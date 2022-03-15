package exercicio05;

public class Produto {
	private String nome, marca;
	private double valor;
	
	public Produto(String nome, String marca, double valor) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
