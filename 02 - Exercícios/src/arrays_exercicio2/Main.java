package arrays_exercicio2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<String> generos = new ArrayList<>();
		ArrayList<String> primeirasNotas = new ArrayList<>();
		ArrayList<String> segundasNotas = new ArrayList<>();
		ArrayList<String> turnos = new ArrayList<>();
		
		infinito: while (true) {
			int opcao = -1;
			try {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("Digite uma op��o: "
								+ "\n1 - Cadastrar"
								+ "\n2 - Listar"
								+ "\n3 - Pesquisar"
								+ "\n4 - Alterar"
								+ "\n5 - Remover"
								+ "\n6 - Sair")
				);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voc� deve digitar um n�mero!");
				continue;
			}
			switch (opcao) {
			case 1:
				nomes.add(JOptionPane.showInputDialog("Digite o nome:"));
				generos.add(JOptionPane.showInputDialog("Digite o g�nero:"));
				primeirasNotas.add(JOptionPane.showInputDialog("Digite a primeira nota:"));
				segundasNotas.add(JOptionPane.showInputDialog("Digite a segunda nota:"));
				turnos.add(JOptionPane.showInputDialog("Digite o turno:"));
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				break;
			case 2:
				for (int i = 0; i < nomes.size(); i++) {
					JOptionPane.showMessageDialog(null, "\nNome: " + nomes.get(i)
							+ "\nG�nero: " + generos.get(i)
							+ "\n1� Nota: " + primeirasNotas.get(i)
							+ "\n2� Nota: " + segundasNotas.get(i)
							+ "\nM�dia: " + (Double.parseDouble(primeirasNotas.get(i)) + Double.parseDouble(segundasNotas.get(i))) / 2
							+ "\nTurno: " + turnos.get(i));
				}
				break;
			case 3:
				String pesquisa = JOptionPane.showInputDialog("Digite o nome do aluno a ser buscado:");
				int indiceAluno = nomes.indexOf(pesquisa);
				
				if (indiceAluno == -1) {
					JOptionPane.showMessageDialog(null, "Nome n�o encontrado!");
					break;
				}
			
				for (int i = 0; i < nomes.size(); i++) {
					if (pesquisa.equalsIgnoreCase(nomes.get(i)))
						JOptionPane.showMessageDialog(null, "\nNome: " + nomes.get(i)
							+ "\nG�nero: " + generos.get(i)
							+ "\n1� Nota: " + primeirasNotas.get(i)
							+ "\n2� Nota: " + segundasNotas.get(i)
							+ "\nM�dia: " + (Double.parseDouble(primeirasNotas.get(i)) + Double.parseDouble(segundasNotas.get(i))) / 2
							+ "\nTurno: " + turnos.get(i));
				}
				
				break;
			case 4:
				pesquisa = JOptionPane.showInputDialog("Digite o nome do aluno a ser alterado:");
				indiceAluno = pesquisaNome(pesquisa, nomes, generos, primeirasNotas, segundasNotas, turnos);
				
				if (indiceAluno == -1) {
					JOptionPane.showMessageDialog(null, "Nome n�o encontrado!");
					break;
				}
				if (indiceAluno < -1) {
					break;
				}
				
				nomes.set(indiceAluno, JOptionPane.showInputDialog("Digite o novo nome:", nomes.get(indiceAluno)));
				generos.set(indiceAluno, JOptionPane.showInputDialog("Digite o novo g�nero:", generos.get(indiceAluno)));
				primeirasNotas.set(indiceAluno, JOptionPane.showInputDialog("Digite a nova 1� nota:", primeirasNotas.get(indiceAluno)));
				segundasNotas.set(indiceAluno, JOptionPane.showInputDialog("Digite a nova 2� nota:", segundasNotas.get(indiceAluno)));
				turnos.set(indiceAluno, JOptionPane.showInputDialog("Digite o novo turno:", turnos.get(indiceAluno)));
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");				
				
				break;
			case 5:
				pesquisa = JOptionPane.showInputDialog("Digite o nome do aluno a ser removido:");
				indiceAluno = pesquisaNome(pesquisa, nomes, generos, primeirasNotas, segundasNotas, turnos);
				
				if (indiceAluno == -1) {
					JOptionPane.showMessageDialog(null, "Nome n�o encontrado!");
					break;
				} 
				if (indiceAluno < -1) {
					break;
				}
				
				nomes.remove(indiceAluno);
				generos.remove(indiceAluno);
				primeirasNotas.remove(indiceAluno);
				segundasNotas.remove(indiceAluno);
				turnos.remove(indiceAluno);
				
				JOptionPane.showMessageDialog(null, "Aluno removido!");
				
				break;
			case 6:
				break infinito;
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			}
		}
	}
	
	/**
	 * 
	 * Pesquisa todas os alunos com o mesmo nome na array, pede que o usu�rio informe qual ele deseja
	 * e retorna o �ndice desta.
	 * 
	 * @param nome - O nome a ser procurado.
	 * 
	 * @return indice - O �ndice da pessoa escolhida no array. Caso n�o encontre nenhuma com o nome, retorna -1.
	 * 
	 */
	static int pesquisaNome(String nome, ArrayList<String> nomes, ArrayList<String> generos,
			ArrayList<String> primeirasNotas, ArrayList<String> segundasNotas, ArrayList<String> turnos) {
		
		ArrayList<Integer> alunosNomeIgual = new ArrayList<>();
		
		for (int i = 0; i < nomes.size(); i++) {
			if (nome.equalsIgnoreCase(nomes.get(i))) {
				alunosNomeIgual.add(i);
			}
		}
		
		if (alunosNomeIgual.size() == 1) {
			return alunosNomeIgual.get(0);
		} 
		
		if (alunosNomeIgual.size() > 1) {
			String listaPessoas = "";
			
			for (int i = 0; i < alunosNomeIgual.size(); i++) {
				listaPessoas += i + ") " + nomes.get(alunosNomeIgual.get(i)) + "\n";
				listaPessoas += "G�nero: " + generos.get(alunosNomeIgual.get(i)) + "\n";
				listaPessoas += "1� Nota: " + primeirasNotas.get(alunosNomeIgual.get(i)) + "\n";
				listaPessoas += "2� Nota: " + segundasNotas.get(alunosNomeIgual.get(i)) + "\n";
				listaPessoas += "M�dia: " + (Double.parseDouble(primeirasNotas.get(i)) + Double.parseDouble(segundasNotas.get(i))) / 2 + "\n";
				listaPessoas += "Turno: " + turnos.get(alunosNomeIgual.get(i)) + "\n";
			}
			
			try {
				int opcaoEscolhida = Integer.parseInt(JOptionPane.showInputDialog("Qual destas deseja? (Digite o n�mero)"
						+ "\n\n" + listaPessoas));
				
				if (opcaoEscolhida < 0 || opcaoEscolhida >= alunosNomeIgual.size())  {
					JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
					return -2;
				}
				
				return alunosNomeIgual.get(opcaoEscolhida);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voc� deve digitar um n�mero!");
				return -2;
			}
			
		}
		return -1;
	}
}
