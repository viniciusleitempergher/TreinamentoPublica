package exercicio01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;

public class CRUDPessoas {
	static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	static void adicionar() {
		Pessoa pessoa = criarPessoa();
		
		pessoas.add(pessoa);
	}
	
	static void alterar(String nome) throws InvalidAttributeValueException {
		int indicePessoa = pesquisaIndice(nome);
		
		if (indicePessoa == -1) {
			throw new InvalidAttributeValueException();
		}

		Pessoa pessoa = criarPessoa();
		pessoas.set(indicePessoa, pessoa);
	}
	
	private static Pessoa criarPessoa() {
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email = JOptionPane.showInputDialog("Digite o email:");
		String telefone = JOptionPane.showInputDialog("Digite o telefone:");
		Date dataNascimento = pedirDataNascimento();		
		String estado = JOptionPane.showInputDialog("Digite o estado:");
		String cidade = JOptionPane.showInputDialog("Digite a cidade:");
		
		Pessoa pessoa = new Pessoa(nome, email, telefone, dataNascimento, estado, cidade);
		return pessoa;
	}
	
	private static Date pedirDataNascimento() {
		Date dataNascimento = new Date();
		boolean invalido = true;
		
		while (invalido) {
			String dataNascimentoString = JOptionPane.showInputDialog("Digite a data de nascimento:");
			try {
				dataNascimento = stringEmDate(dataNascimentoString);
				invalido = false;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Data inválida!");
			}
		}
		
		return dataNascimento;
	}
	
	static Date stringEmDate(String data) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return df.parse(data);
	}
	static String dateEmString(Date data) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return df.format(data);
	}
	
	static void pesquisaPessoa(String nome) throws InvalidAttributeValueException, ParseException {
		int indicePessoa = pesquisaIndice(nome);
		
		if (indicePessoa == -1) {
			throw new InvalidAttributeValueException();
		}

		Pessoa pessoa = pessoas.get(indicePessoa);
		
		mostraPessoa(pessoa);
	}
	
	static void mostraPessoa(Pessoa pessoa) throws ParseException {
		JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome()
		+ "\nEmail: " + pessoa.getEmail()
		+ "\nTelefone: " + pessoa.getTelefone()
		+ "\nNascimento: " + dateEmString(pessoa.getDataNascimento())
		+ "\nEstado: " + pessoa.getEstado()
		+ "\nCidade: " + pessoa.getCidade()
		);
	}
	
	private static int pesquisaIndice(String nome) {
		int indicePessoa = -1;
		
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
				indicePessoa = i;
				break;
			}
		}
		return indicePessoa;
	}
	
	static void remover(String nome) throws InvalidAttributeValueException {
		int indicePessoa = pesquisaIndice(nome);
		
		if (indicePessoa == -1) {
			throw new InvalidAttributeValueException();
		}
		
		pessoas.remove(indicePessoa);
	}
	
	static ArrayList<Pessoa> retornaAniversariantes() {
		ArrayList<Pessoa> aniversariantes = new ArrayList<>();
		
		for (int i = 0; i < pessoas.size(); i++) {
			Pessoa pessoa = pessoas.get(i);
			
			if (aniversariante(pessoa)) aniversariantes.add(pessoa);
		}
		
		return aniversariantes;
	}
	
	static boolean aniversariante(Pessoa pessoa) {
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataAniversario = Calendar.getInstance();
		dataAniversario.setTime(pessoa.getDataNascimento());
		
		if (dataAtual.get(Calendar.MONTH) == dataAniversario.get(Calendar.MONTH)) {
			return true;
		}
		return false;
	}
}
