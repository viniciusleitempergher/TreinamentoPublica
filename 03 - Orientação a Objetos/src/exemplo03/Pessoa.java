package exemplo03;

public class Pessoa {
	/*
	 * DEFAULT	: Atributos e m�todos vis�veis apenas no mesmo pacote
	 * PUBLIC	: Atributos e m�todos vis�veis em todo o projeto
	 * PRIVATE	: Atributos e m�todos vis�veis na classe onde s�o criados
	 * PROTECTED: Atributos e m�todos vis�veis nas classes onde s�o criados ou herdados
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
