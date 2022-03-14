package exercicio02;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CRUD {
	static ArrayList<Turma> turmas = new ArrayList<>();
	static ArrayList<Prova> provas = new ArrayList<>();
	static ArrayList<Nota> notas = new ArrayList<>();
	
	static void cadastrarAluno() {
		Aluno aluno = criarAluno();
		String turma = JOptionPane.showInputDialog("Informe a turma:");

		int indiceTurma = encontrarTurma(turma);
		
		if (indiceTurma == -1) {
			JOptionPane.showMessageDialog(null, "Turma não encontrada!");
			String opcao = JOptionPane.showInputDialog("Deseja criar uma nova? sim/não");
			if (opcao.equalsIgnoreCase("sim")) {
				turmas.add(new Turma(turma));
				indiceTurma = turmas.size() - 1;
				JOptionPane.showMessageDialog(null, "Turma criada!");
			} else {
				return;
			}
		}
		
		turmas.get(indiceTurma).alunos.add(aluno);
	}
	
	private static int encontrarTurma(String turma) {
		for (int i = 0; i < turmas.size(); i++) {
			if (turma.equalsIgnoreCase(turmas.get(i).nome)) return i;
		}

		return -1;
	}
	
	private static Aluno criarAluno() {
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String dataAniversario = JOptionPane.showInputDialog("Digite a data de aniversário:");
		String telefone = JOptionPane.showInputDialog("Digite o telefone:");
		
		return new Aluno(nome, dataAniversario, telefone);
	}

	static void cadastrarProva() {
		provas.add(criarProva());
	}
	
	static Prova criarProva() {
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String materia = JOptionPane.showInputDialog("Digite a matéria:");
		
		return new Prova(nome, materia);
	}
	
	static void cadastrarNota() {
		int indiceProva = encontrarProva(JOptionPane.showInputDialog("Digite o nome da prova:"));
		if (indiceProva == -1) return;
		int indiceAluno[] = selecionarAluno();
		
		notas.add(criarNota(indiceAluno, indiceProva));
	}
	
	private static Nota criarNota(int indiceAluno[], int indiceProva) {
		double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota:"));
		return new Nota(indiceAluno[0], indiceAluno[1], indiceProva, nota);
	}

	static void alterarAluno() {		
		int[] indiceAluno = selecionarAluno();
		
		Aluno aluno = criarAluno();
		
		turmas.get(indiceAluno[0]).alunos.set(indiceAluno[1], aluno);
	}
	
	static void alterarProva() {
		int indiceProva = encontrarProva(JOptionPane.showInputDialog("Digite o nome da prova:"));
		Prova prova = criarProva();
		provas.set(indiceProva, prova);
	}
	
	static void alterarNota() {
		int[] indices = selecionarAluno();
		
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).codigoAluno == indices[1]
					&& notas.get(i).codigoTurmaAluno == indices[0]) {
				notas.set(i, criarNota(indices, i));
			}
		}
	}
	
	static int encontrarProva(String nome) {
		for (int i = 0; i < provas.size(); i++) {
			if (provas.get(i).nome.equalsIgnoreCase(nome)) return i;
		}
		return -1;
	}
	
	static void removerAluno() {
		int[] indiceAluno = selecionarAluno();
		
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).codigoAluno == indiceAluno[1]) {
				notas.remove(i);
			}
		}
		
		turmas.get(indiceAluno[0]).alunos.remove(indiceAluno[1]);
	}
	
	static void removerProva() {
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		
		int indiceProva = encontrarProva(nome);
		
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).codigoProva == indiceProva) {
				notas.remove(i);
			}
		}
		
		provas.remove(indiceProva);
	}
	
	static void removerNota() {
		int[] indiceAluno = selecionarAluno();
		
		String stringProvas = "Qual destas deseja remover? \n\n";
		
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).codigoAluno == indiceAluno[0]
					&& notas.get(i).codigoTurmaAluno == indiceAluno[1]) {
				stringProvas += i + ") " + provas.get(i).nome + "\nMatéria: " + provas.get(i).materia + "\n";
			}
		}
		
		JOptionPane.showInputDialog(stringProvas);
	}
	
	static void pesquisarAluno() {		
		int[] indiceAluno = selecionarAluno();
		Aluno aluno = turmas.get(indiceAluno[0]).alunos.get(indiceAluno[1]);
		
		String notasString = "";
		boolean temUma = false;
		double soma = 0;
		int quantidadeProvas = 0;
		
		for (Nota nota : notas) {
			if (nota.codigoTurmaAluno == indiceAluno[0]
					&& nota.codigoAluno == indiceAluno[1]) {
				temUma = true;
				notasString += "Nota: " + nota.nota + "\n";
				soma += nota.nota;
				quantidadeProvas++;
				notasString += "Prova: " + provas.get(nota.codigoProva).nome + "\n";
				notasString += "Matéria: " + provas.get(nota.codigoProva).materia + "\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, 
					"Nome: " + aluno.getNome() + "\n" +
					"Data de Nascimento: " + aluno.getDataNascimento() + "\n" +
					"Telefone: " + aluno.getTelefone() + "\n" +
					"Notas:" + "\n" + (temUma ? notasString : "Nenhuma nota!") + "\n" +
					"Média: " + soma / quantidadeProvas
				);
	}
	
	private static int[] selecionarAluno() {
		String[] opcoes = {
				"Nome",
                "Turma",
                };
		
		int opcao = JOptionPane.showOptionDialog(null,
			"Como deseja selecionar:",
			"Sistema de Alunos",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			opcoes,
			opcoes[0]
		);
		
		int indexTurma = -1;
		int indexAluno = -1;
		
		if (opcao == 0) {
			String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
			
			for (int i = 0; i < turmas.size(); i++) {
				Turma turma = turmas.get(i);
				
				for (int l = 0; l < turma.alunos.size(); l++) {
					if (turma.alunos.get(i).getNome().equalsIgnoreCase(nome)) {
						indexAluno = l;
						indexTurma = i;
						return new int[] { indexTurma, indexAluno };
					}
				}
			}
		}
		
		if (opcao == 1) {
			String nome = JOptionPane.showInputDialog("Digite o nome da turma:");
			indexTurma = encontrarTurma(nome);
			String alunosString = "";
			Turma turma = turmas.get(indexTurma);
			
			for (int i = 0; i < turma.alunos.size(); i++) {
				alunosString += i + ") " + turma.alunos.get(i).getNome() + "\n";
			}
			indexAluno = Integer.parseInt(
						JOptionPane.showInputDialog("Escolha uma opção: \n\n" + alunosString)
					);
		}
		
		return new int[] { indexTurma, indexAluno };
	}
}
