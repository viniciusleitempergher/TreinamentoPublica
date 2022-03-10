package arrays_exercicio1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<Integer> idades = new ArrayList<>();
		ArrayList<String> emails = new ArrayList<>();
		ArrayList<String> telefones = new ArrayList<>();
		ArrayList<String> cidades = new ArrayList<>();
		
		infinito: while (true) {
			int opcao = -1;
			try {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("Digite uma opção: "
								+ "\n1 - Cadastrar"
								+ "\n2 - Listar"
								+ "\n3 - Pesquisar"
								+ "\n4 - Alterar"
								+ "\n5 - Remover"
								+ "\n6 - Sair")
				);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Você deve digitar um número!");
				continue;
			}
			switch (opcao) {
			case 1:
				nomes.add(JOptionPane.showInputDialog("Digite o nome:"));
				idades.add(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
				emails.add(JOptionPane.showInputDialog("Digite email:"));
				telefones.add(JOptionPane.showInputDialog("Digite o telefone:"));
				cidades.add(JOptionPane.showInputDialog("Digite a cidade:"));
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				break;
			case 2:
				for (int i = 0; i < nomes.size(); i++) {
					JOptionPane.showMessageDialog(null, "\nNome: " + nomes.get(i)
							+ "\nIdade: " + idades.get(i)
							+ "\nEmail: " + emails.get(i)
							+ "\nTelefone: " + telefones.get(i)
							+ "\nCidade: " + cidades.get(i));
				}
				break;
			case 3:
				String pesquisa = JOptionPane.showInputDialog("Digite o nome a ser buscado:");
				int indicePessoa = nomes.indexOf(pesquisa);
				
				if (indicePessoa == -1) {
					JOptionPane.showMessageDialog(null, "Nome não encontrado!");
					break;
				}
			
				for (int i = 0; i < nomes.size(); i++) {
					if (pesquisa.equalsIgnoreCase(nomes.get(i)))
						JOptionPane.showMessageDialog(null, "\nNome: " + nomes.get(i)
							+ "\nIdade: " + idades.get(i)
							+ "\nEmail: " + emails.get(i)
							+ "\nTelefone: " + telefones.get(i)
							+ "\nCidade: " + cidades.get(i));
				}
				
				break;
			case 4:
				pesquisa = JOptionPane.showInputDialog("Digite o nome a ser alterado:");
				indicePessoa = pesquisaNome(pesquisa, nomes, cidades, emails, telefones, cidades);
				
				if (indicePessoa == -1) {
					JOptionPane.showMessageDialog(null, "Nome não encontrado!");
					break;
				}
				if (indicePessoa < -1) {
					break;
				}
				
				nomes.set(indicePessoa, JOptionPane.showInputDialog("Digite o novo nome:", nomes.get(indicePessoa)));
				idades.set(indicePessoa, Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade:", idades.get(indicePessoa))));
				emails.set(indicePessoa, JOptionPane.showInputDialog("Digite o novo email:", emails.get(indicePessoa)));
				telefones.set(indicePessoa, JOptionPane.showInputDialog("Digite o novo telefone:", telefones.get(indicePessoa)));
				cidades.set(indicePessoa, JOptionPane.showInputDialog("Digite a nova cidade:", cidades.get(indicePessoa)));
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");				
				
				break;
			case 5:
				pesquisa = JOptionPane.showInputDialog("Digite o nome a ser removido:");
				indicePessoa = pesquisaNome(pesquisa, nomes, cidades, emails, telefones, cidades);
				
				if (indicePessoa == -1) {
					JOptionPane.showMessageDialog(null, "Nome não encontrado!");
					break;
				} 
				if (indicePessoa < -1) {
					break;
				}
				
				nomes.remove(indicePessoa);
				idades.remove(indicePessoa);
				emails.remove(indicePessoa);
				telefones.remove(indicePessoa);
				cidades.remove(indicePessoa);
				
				JOptionPane.showMessageDialog(null, "Pessoa removida!");
				
				break;
			case 6:
				break infinito;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
	
	/**
	 * 
	 * Pesquisa todas as pessoas com o mesmo nome na array, pede que o usuário informe qual ele deseja
	 * e retorna o índice desta.
	 * 
	 * @param nome - O nome a ser procurado.
	 * 
	 * @return indice - O índice da pessoa escolhida no array. Caso não encontre nenhuma com o nome, retorna -1.
	 * 
	 */
	static int pesquisaNome(String nome, ArrayList<String> nomes, ArrayList<String> idades,
			ArrayList<String> emails, ArrayList<String> telefones, ArrayList<String> cidades) {
		
		ArrayList<Integer> pessoasNomeIgual = new ArrayList<>();
		
		for (int i = 0; i < nomes.size(); i++) {
			if (nome.equalsIgnoreCase(nomes.get(i))) {
				pessoasNomeIgual.add(i);
			}
		}
		
		if (pessoasNomeIgual.size() == 1) {
			return pessoasNomeIgual.get(0);
		} 
		
		if (pessoasNomeIgual.size() > 1) {
			String listaPessoas = "";
			
			for (int i = 0; i < pessoasNomeIgual.size(); i++) {
				listaPessoas += i + ") " + nomes.get(pessoasNomeIgual.get(i)) + "\n";
				listaPessoas += "Idade: " + idades.get(pessoasNomeIgual.get(i)) + "\n";
				listaPessoas += "Email: " + emails.get(pessoasNomeIgual.get(i)) + "\n";
				listaPessoas += "Telefone: " + telefones.get(pessoasNomeIgual.get(i)) + "\n";
				listaPessoas += "Cidade: " + cidades.get(pessoasNomeIgual.get(i)) + "\n";
			}
			
			try {
				int opcaoEscolhida = Integer.parseInt(JOptionPane.showInputDialog("Qual destas deseja? (Digite o número)"
						+ "\n\n" + listaPessoas));
				
				if (opcaoEscolhida < 0 || opcaoEscolhida >= pessoasNomeIgual.size())  {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					return -2;
				}
				
				return pessoasNomeIgual.get(opcaoEscolhida);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Você deve digitar um número!");
				return -2;
			}
			
		}
		return -1;
	}
}
