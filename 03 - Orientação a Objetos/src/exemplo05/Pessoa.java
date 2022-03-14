package exemplo05;

public class Pessoa {
	public Pessoa() {
		System.out.println("Construtor executado!");
	}
	
	public Pessoa(String nome) {
		System.out.println("Bom dia " + nome);
	}

	public Pessoa(String nome, int idade) {
		System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
	}
}
