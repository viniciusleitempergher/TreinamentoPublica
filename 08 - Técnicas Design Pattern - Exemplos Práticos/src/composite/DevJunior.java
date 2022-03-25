package composite;

// Leaf
public class DevJunior implements Funcionario {
	private String nome, cargo;
	private double salario;
	
	public DevJunior(String nome, double salario) {
		super();
		this.nome = nome;
		this.cargo = "Dev Júnior";
		this.salario = salario;
	}
	
	public void mostraInformacoes() {
		System.out.println("Nome: " + nome);
		System.out.println("Cargo: " + cargo);
		System.out.println("Salário: " + salario);
		System.out.println("========================");
	}
	
	public double getSalarioTotal() {
		return salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}	
}
