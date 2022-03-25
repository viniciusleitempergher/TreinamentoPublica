package composite;

import java.util.ArrayList;

// Composite
public class DevPleno implements Funcionario {
	private String nome, cargo;
	private double salario;
	private ArrayList<DevJunior> funcionarios;
	
	public DevPleno(String nome, double salario) {
		this.nome = nome;
		this.cargo = "Dev Pleno";
		this.salario = salario;
		this.funcionarios = new ArrayList<>();
	}
	
	public void mostraInformacoes() {
		System.out.println("Nome: " + getNome());
		System.out.println("Cargo: " + getCargo());
		System.out.println("Salário: " + getSalario());
		System.out.println("========================");
		
		for (Funcionario f : funcionarios) {
			f.mostraInformacoes();
		}
	}
	
	public void adicionarFuncionario(DevJunior junior) {
		funcionarios.add(junior);
	}
	
	public double getSalarioTotal() {
		double total = getSalario();
		
		for (Funcionario f : funcionarios) {
			total += f.getSalarioTotal();
		}
		
		return total;
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
	public ArrayList<DevJunior> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(ArrayList<DevJunior> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
