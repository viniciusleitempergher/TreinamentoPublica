package exemplo12;

public class Desenvolvedor extends Calculos {

	@Override
	public void valeAlimentacao(double salario) {
		System.out.println("Vale alimentação desenvolvedor: " + salario * 0.15);
	}
}
