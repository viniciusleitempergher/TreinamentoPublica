package exercicio03;

import java.util.ArrayList;

public class Conta {
	private String agencia, contaCorrente;
	private double saldo;
	ArrayList<Movimentacao> movimentacoes;
	
	public Conta(String agencia, String contaCorrente,
			double saldo) {
		this.agencia = agencia;
		this.contaCorrente = contaCorrente;
		this.saldo = saldo;
		movimentacoes = new ArrayList<>();
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
