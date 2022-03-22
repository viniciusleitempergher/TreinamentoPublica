package exercicio05;

import java.util.ArrayList;

public class Aluno {
	private String nome, sexo;
	private int idade;
	private ArrayList<Double> notas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public ArrayList<Double> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}
}
