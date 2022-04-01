package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private double nota1;
	private double nota2;
	private char turno;
	private char genero;
	
	public String getTurnoExtenso() {
		if (turno == 'm') return "Matutino";
		if (turno == 'v') return "Vespertino";
		return "Noturno";
	}
	public String getGeneroExtenso() {
		if (genero == 'f') return "Feminino";
		return "Masculino";
	}
	public String getSituacao() {
		return getMedia() < 7 ? "Reprovado" : "Aprovado";
	}
	public double getMedia() {
		return (nota1 + nota2) / 2;
	}
	
	// Getters n Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public char getTurno() {
		return turno;
	}
	public void setTurno(char turno) {
		this.turno = turno;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
}
