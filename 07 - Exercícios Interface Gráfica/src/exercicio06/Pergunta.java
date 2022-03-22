package exercicio06;

public class Pergunta {
	private String texto;
	private String[] alternativas;
	private int indiceResposta;
	
	public Pergunta(String texto, String[] alternativas, int indiceResposta) {
		this.texto = texto;
		this.alternativas = alternativas;
		this.indiceResposta = indiceResposta;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String[] getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(String[] alternativas) {
		this.alternativas = alternativas;
	}
	public int getIndiceResposta() {
		return indiceResposta;
	}
	public void setIndiceResposta(int indiceResposta) {
		this.indiceResposta = indiceResposta;
	}
}
