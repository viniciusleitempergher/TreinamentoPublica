package exercicio05;

import java.util.ArrayList;
import java.util.Date;

public class ListaPresenca {
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private String data;
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}
