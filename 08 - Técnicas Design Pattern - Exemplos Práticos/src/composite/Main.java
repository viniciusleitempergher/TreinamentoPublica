package composite;

public class Main {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		
		DevSenior devSenior = new DevSenior("Lariel", 10000);
		DevPleno devPleno = new DevPleno("Julio", 6000);
		devPleno.adicionarFuncionario(new DevJunior("Pedrão", 3500));
		devPleno.adicionarFuncionario(new DevJunior("Jorjão", 3500));
		devPleno.adicionarFuncionario(new DevJunior("Brunão", 3500));
		
		devSenior.adicionarFuncionario(devPleno);
		
		devPleno = new DevPleno("Lewis", 6000);
		devPleno.adicionarFuncionario(new DevJunior("Josevaldo", 3500));
		devPleno.adicionarFuncionario(new DevJunior("Josefino", 3500));
		devPleno.adicionarFuncionario(new DevJunior("Henrique", 3500));
		
		devSenior.adicionarFuncionario(devPleno);
		
		empresa.addFuncionario(devSenior);
		
		devSenior = new DevSenior("Edward", 10000);
		empresa.addFuncionario(devSenior);

		empresa.mostraInformacoes();
		System.out.println("Soma de todos os salários: " + empresa.getSalarioTotal());;
	}

}
