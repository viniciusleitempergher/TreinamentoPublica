package exercicio05;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JanelaProfessor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBox;
	private JLabel lblQuantidadeMeninos;
	private JLabel lblQuantidadeMeninas;
	private JLabel lblMediaAlta;
	private JLabel lblMediaBaixa;

	/**
	 * Create the frame.
	 */
	public JanelaProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarNotas = new JButton("Adicionar Notas");
		btnAdicionarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcoes = "Qual prova? (Digite o número)\n\n";
				for (int i = 0; i < Dados.provas.size(); i++) {
					opcoes += i + ") " + Dados.provas.get(i) + "\n";
				}
				int opcao = Integer.parseInt(
							JOptionPane.showInputDialog(opcoes));
				
				for (Aluno a : Dados.alunos) {
					double nota = Double.parseDouble(
							JOptionPane.showInputDialog("Digite o a nota de " + a.getNome()));
					
					while (a.getNotas().size() <= opcao)
						a.getNotas().add(0.0);
					
					a.getNotas().set(opcao, nota);
				}
				atualizarTabela();
			}
		});
		btnAdicionarNotas.setBounds(534, 62, 129, 21);
		contentPane.add(btnAdicionarNotas);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = JOptionPane.showInputDialog("Digite a data");
				ArrayList<Aluno> alunosPresentes = new ArrayList<>();
				
				for (Aluno a : Dados.alunos) {
					String opcao = JOptionPane.showInputDialog(a.getNome() + " está presente? s/n");
					if (opcao.charAt(0) == 's') {
						alunosPresentes.add(a);
					}
				}
				
				ListaPresenca chamada = new ListaPresenca();
				chamada.setData(data);
				chamada.setAlunos(alunosPresentes);
				
				Dados.chamadas.add(chamada);
				atualizarTabela();
			}
		});
		btnChamada.setBounds(534, 94, 129, 21);
		contentPane.add(btnChamada);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(10, 62, 201, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("Selecione um aluno:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 719, 302);
		contentPane.add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Sexo");
		dtm.addColumn("Idade");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaLogin login = new JanelaLogin();
				login.setVisible(true);
				fechar();
			}
		});
		btnLogout.setBounds(534, 125, 129, 21);
		contentPane.add(btnLogout);
		
		JButton btnAdicionarAluno = new JButton("Adicionar Aluno");
		btnAdicionarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaInformacoesAluno janelaCadastro = new JanelaInformacoesAluno(-1);
				janelaCadastro.setVisible(true);
				fechar();
			}
		});
		btnAdicionarAluno.setBounds(360, 31, 129, 21);
		contentPane.add(btnAdicionarAluno);
		
		JButton btnEditar = new JButton("Editar Aluno");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um aluno!");
					return;
				}
				int indiceAluno = comboBox.getSelectedIndex() - 1;
				
				JanelaInformacoesAluno janelaEdicao = new JanelaInformacoesAluno(indiceAluno);
				janelaEdicao.setVisible(true);
				fechar();
			}
		});
		
		btnEditar.setBounds(221, 62, 129, 21);
		contentPane.add(btnEditar);
		
		
		JButton btnRemoverAluno = new JButton("Remover Aluno");
		btnRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um aluno!");
					return;
				}
				int indiceAluno = comboBox.getSelectedIndex() - 1;
				
				Dados.alunos.remove(indiceAluno);
				atualizarTabela();
				JOptionPane.showMessageDialog(null, "Aluno removido!");
			}
		});
		btnRemoverAluno.setBounds(360, 62, 129, 21);
		contentPane.add(btnRemoverAluno);
		
		JButton btnAdicionarProva = new JButton("Adicionar Prova");
		btnAdicionarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dados.provas.add(JOptionPane.showInputDialog("Digite o nome da prova:"));
				
				for (Aluno a : Dados.alunos) {
					a.getNotas().add(0.0);
				}
				
				atualizarTabela();
			}
		});
		btnAdicionarProva.setBounds(534, 31, 129, 21);
		contentPane.add(btnAdicionarProva);
		
		JLabel lblTxtQuantidadeMeninos = new JLabel("Quantidade de meninos:");
		lblTxtQuantidadeMeninos.setBounds(10, 485, 244, 13);
		contentPane.add(lblTxtQuantidadeMeninos);
		
		JLabel lblTxtQuantidadeDeMeninas = new JLabel("Quantidade de meninas:");
		lblTxtQuantidadeDeMeninas.setBounds(10, 498, 244, 13);
		contentPane.add(lblTxtQuantidadeDeMeninas);
		
		JLabel lblQuantidadeDeAlunos = new JLabel("Quantidade de alunos com m\u00E9dia maior ou igual a 7:");
		lblQuantidadeDeAlunos.setBounds(10, 521, 300, 13);
		contentPane.add(lblQuantidadeDeAlunos);
		
		JLabel lblQuantidadeDeAlunos_1 = new JLabel("Quantidade de alunos com m\u00E9dia inferior a 7:");
		lblQuantidadeDeAlunos_1.setBounds(10, 533, 275, 13);
		contentPane.add(lblQuantidadeDeAlunos_1);
		
		lblQuantidadeMeninos = new JLabel("0");
		lblQuantidadeMeninos.setBounds(168, 485, 45, 13);
		contentPane.add(lblQuantidadeMeninos);
		
		lblQuantidadeMeninas = new JLabel("0");
		lblQuantidadeMeninas.setBounds(168, 498, 45, 13);
		contentPane.add(lblQuantidadeMeninas);
		
		lblMediaAlta = new JLabel("0");
		lblMediaAlta.setBounds(305, 521, 69, 13);
		contentPane.add(lblMediaAlta);
		
		lblMediaBaixa = new JLabel("0");
		lblMediaBaixa.setBounds(305, 533, 69, 13);
		contentPane.add(lblMediaBaixa);
		
		atualizarTabela();
	}
	
	private void fechar() {
		this.dispose();
	}
	
	private void atualizarTabela() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Idade");
		dtm.addColumn("Gênero");
		
		for (String p : Dados.provas) {
			dtm.addColumn(p);
		}
		
		for (ListaPresenca lp : Dados.chamadas) {
			dtm.addColumn(lp.getData());
		}
		
		int homens = 0;
		int mulheres = 0;
			
		comboBox.removeAllItems();
		
		comboBox.addItem("Selecione um aluno:");
		
		ArrayList<Double> medias = new ArrayList<>();
		
		for (int i = 0; i < Dados.provas.size(); i++) {
			double soma = 0;
			for (Aluno a : Dados.alunos) {
				if (a.getNotas().size() > i)
					soma += a.getNotas().get(i);
			}
			
			medias.add(soma / Dados.alunos.size());
		}
		
		for (Aluno a : Dados.alunos) {
			ArrayList<String> colunas = new ArrayList<>();
			colunas.add(a.getNome());
			colunas.add(a.getIdade() + "");
			colunas.add(a.getSexo());
			
			for (double nota : a.getNotas()) {
				colunas.add(nota + "");
			}
			
			for (ListaPresenca lp : Dados.chamadas) {
				boolean presente = false;
				for (Aluno alunoPresente : lp.getAlunos()) {
					if (alunoPresente.getNome().equals(a.getNome())) {
						presente = true;
						break;
					}
				}
				colunas.add(presente ? "P" : "F");
			}
			
			dtm.addRow(colunas.toArray());
			
			comboBox.addItem(a.getNome());
			
			if (a.getSexo().equals("M")) homens++;
			else mulheres++;
		}
		
		ArrayList<String> mediaTurmaLinha = new ArrayList<>();
		
		mediaTurmaLinha.add("Média da Turma");
		mediaTurmaLinha.add(null);
		mediaTurmaLinha.add(null);
		
		for (double d : medias) {
			mediaTurmaLinha.add(d + "");
		}
	
		dtm.addRow(mediaTurmaLinha.toArray());
		
		double quantidadeAcimaMedia = 0;
		double quantidadeAbaixoMedia = 0;
		
		for (Aluno a : Dados.alunos) {
			double soma = 0, quantidade = Dados.provas.size();
			for (double n : a.getNotas()) {
				soma += n;
			}
			if (soma / quantidade < 7) {
				quantidadeAbaixoMedia++;
			} else if (soma / quantidade >= 7) {
				quantidadeAcimaMedia++;
			}
		}
		
		lblQuantidadeMeninos.setText(homens + "");
		lblQuantidadeMeninas.setText(mulheres + "");
		
		int total = (int) (quantidadeAcimaMedia + quantidadeAbaixoMedia);
		lblMediaAlta.setText(quantidadeAcimaMedia + " (" + quantidadeAcimaMedia / total * 100 + "%)");
		lblMediaBaixa.setText(quantidadeAbaixoMedia + " (" + quantidadeAbaixoMedia / total * 100 + "%)");
		
		table.setModel(dtm);
	}
}
