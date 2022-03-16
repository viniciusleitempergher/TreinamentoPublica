package exemplo12;

public class Main {
	public static void main(String[] args) {
		
		Calculos objDesenvolvedor = new Desenvolvedor();
		objDesenvolvedor.valeAlimentacao(1000);
		objDesenvolvedor.valeTransporte(1000);
		
		Calculos objAnalista = new Analista();
		objAnalista.valeAlimentacao(1000);
		objAnalista.valeTransporte(1000);
	}
}
