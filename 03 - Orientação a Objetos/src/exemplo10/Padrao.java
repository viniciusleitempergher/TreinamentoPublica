package exemplo10;

public abstract class Padrao {

	public abstract int soma(int n1, int n2);
	public abstract int subtracao(int n1, int n2);
	public abstract int multiplicacao(int n1, int n2);
	public abstract double divisao(int n1, int n2);
	
	public double media(double n1, double n2) {
		return (n1 + n2) / 2;
	}
	
}
