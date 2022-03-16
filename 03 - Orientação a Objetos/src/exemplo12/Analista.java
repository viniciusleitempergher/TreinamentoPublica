package exemplo12;

public class Analista extends Calculos {
	@Override
	public void valeTransporte(double salario) {
		System.out.println("Vale transporte analista: " + salario * 0.1);
	}
	
	@Override
	public void valeAlimentacao(double salario) {
		System.out.println("Vale alimentação analista: " + salario * 0.2);
	}
}
