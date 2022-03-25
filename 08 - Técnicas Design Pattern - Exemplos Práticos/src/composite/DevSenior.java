package composite;

import java.util.ArrayList;

// Composite
public class DevSenior implements Funcionario {
	private String nome, cargo;
	private double salario;
	private ArrayList<DevPleno> funcionarios;
	
	public DevSenior(String nome, double salario) {
		this.nome = nome;
		this.cargo = "Dev Sênior";
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
	
	public void adicionarFuncionario(DevPleno pleno) {
		funcionarios.add(pleno);
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
	public ArrayList<DevPleno> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(ArrayList<DevPleno> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
