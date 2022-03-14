package exercicio03;

import java.util.Date;

public class Movimentacao {
	
	private double valor;
	private Date data;
	
	public Movimentacao(double valor) {
		super();
		this.valor = valor;
		this.data = new Date();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
