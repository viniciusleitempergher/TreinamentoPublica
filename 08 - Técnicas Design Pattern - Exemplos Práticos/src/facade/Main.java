package facade;

public class Main {
	public static void main(String[] args) {
		CarEngineFacade fachadaCarro = new CarEngineFacade();
		
		fachadaCarro.startEngine();
		fachadaCarro.stopEngine();
	}
}
