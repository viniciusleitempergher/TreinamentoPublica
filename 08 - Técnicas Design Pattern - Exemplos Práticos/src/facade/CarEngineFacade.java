package facade;

public class CarEngineFacade {
	    private static int DEFAULT_COOLING_TEMP = 90;
	    private static int MAX_ALLOWED_TEMP = 50;
	    private FuelInjector fuelInjector = new FuelInjector();
	    private AirFlowController airFlowController = new AirFlowController();
	    private Starter starter = new Starter();
	    private CoolingController coolingController = new CoolingController();
	    private CatalyticConverter catalyticConverter = new CatalyticConverter();

	    public void startEngine() {
	    	System.out.println("\nLigando o carro!\n");
	        airFlowController.takeAir();
	        fuelInjector.on();
	        fuelInjector.inject();
	        starter.start();
	        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
	        coolingController.run();
	        catalyticConverter.on();
	    }

	    public void stopEngine() {
	    	System.out.println("\nDesligando o carro!\n");
	        fuelInjector.off();
	        catalyticConverter.off();
	        coolingController.cool(MAX_ALLOWED_TEMP);
	        coolingController.stop();
	        airFlowController.off();
	    }
}
