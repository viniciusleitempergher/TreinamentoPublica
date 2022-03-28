package facade;

public class CoolingController {
	public void setTemperatureUpperLimit(int temperaturaMaxima) {
		System.out.println("Definindo a temperatura máxima para: " + temperaturaMaxima);
	}
	public void run() {
		System.out.println("Ativando sistema de refrigeramento!");
	}
	public void cool(int temperatura) {
		System.out.println("Resfriando o motor para " + temperatura + " graus!");
	}
	public void stop() {
		System.out.println("Desativando sistema de refrigeramento!");
	}
}
