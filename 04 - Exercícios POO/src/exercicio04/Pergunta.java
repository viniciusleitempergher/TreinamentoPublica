package exercicio04;

import java.util.ArrayList;

public class Pergunta {
	private String texto, dica;
	private ArrayList<String> alternativas;
	private int iAlternativaCorreta;
	
	public Pergunta(String texto, String dica, ArrayList<String> alternativas, int iAlternativaCorreta) {
		super();
		this.texto = texto;
		this.alternativas = alternativas;
		this.iAlternativaCorreta = iAlternativaCorreta;
		this.dica = dica;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ArrayList<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(ArrayList<String> alternativas) {
		this.alternativas = alternativas;
	}

	public int getiAlternativaCorreta() {
		return iAlternativaCorreta;
	}

	public void setiAlternativaCorreta(int iAlternativaCorreta) {
		this.iAlternativaCorreta = iAlternativaCorreta;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}
}
