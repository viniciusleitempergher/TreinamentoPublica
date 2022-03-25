package composite;

import java.util.ArrayList;

// Client
public class Empresa {
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	public void mostraInformacoes() {
		for (Funcionario f : funcionarios) {
			f.mostraInformacoes();
		}
	}
	
	public double getSalarioTotal() {
		double total = 0;
		for (Funcionario f : funcionarios) {
			total += f.getSalarioTotal();
		}
		return total;
	}

	public void addFuncionario(Funcionario f) {
		funcionarios.add(f);
	}
	
	public void removeFuncionario(Funcionario f) {
		funcionarios.remove(f);
	}
	
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
