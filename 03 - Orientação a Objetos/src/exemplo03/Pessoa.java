package exemplo03;

public class Pessoa {
	/*
	 * DEFAULT	: Atributos e métodos visíveis apenas no mesmo pacote
	 * PUBLIC	: Atributos e métodos visíveis em todo o projeto
	 * PRIVATE	: Atributos e métodos visíveis na classe onde são criados
	 * PROTECTED: Atributos e métodos visíveis nas classes onde são criados ou herdados
	 */
	
	String nome;
	public int idade;
	private double peso;
	protected double altura;
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
