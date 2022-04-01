package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import acoes.AcoesAluno;
import entidade.Aluno;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboAlunos;
	
	private JLabel lblAprovados;
	private JLabel lblReprovados;
	private JLabel lblHomens;
	private JLabel lblMulheres;
	private JLabel lblVespertino;
	private JLabel lblMatutino;
	private JLabel lblNoturno;
	private JLabel lblTotalAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 898, 392);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("Cadastrar Aluno");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				fechar();
			}
		});
		btnCadastrar.setBounds(10, 424, 345, 21);
		contentPane.add(btnCadastrar);
		
		comboAlunos = new JComboBox<String>();
		comboAlunos.setBounds(389, 423, 345, 21);
		contentPane.add(comboAlunos);
		
		JButton btnEditar = new JButton("Editar Aluno");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(389, 454, 158, 21);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover Aluno");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(576, 454, 158, 21);
		contentPane.add(btnRemover);
		
		JLabel lblNewLabel = new JLabel("Estat\u00EDsticas:");
		lblNewLabel.setBounds(10, 489, 177, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aprovados:");
		lblNewLabel_1.setBounds(10, 512, 73, 13);
		contentPane.add(lblNewLabel_1);
		
		lblAprovados = new JLabel("0");
		lblAprovados.setBounds(93, 512, 94, 13);
		contentPane.add(lblAprovados);
		
		lblReprovados = new JLabel("0");
		lblReprovados.setBounds(93, 535, 94, 13);
		contentPane.add(lblReprovados);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reprovados:");
		lblNewLabel_1_1.setBounds(10, 535, 73, 13);
		contentPane.add(lblNewLabel_1_1);
		
		lblHomens = new JLabel("0");
		lblHomens.setBounds(93, 558, 94, 13);
		contentPane.add(lblHomens);
		
		JLabel lblNewLabel_1_2 = new JLabel("Homens:");
		lblNewLabel_1_2.setBounds(10, 558, 73, 13);
		contentPane.add(lblNewLabel_1_2);
		
		lblMulheres = new JLabel("0");
		lblMulheres.setBounds(93, 581, 94, 13);
		contentPane.add(lblMulheres);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mulheres:");
		lblNewLabel_1_3.setBounds(10, 581, 73, 13);
		contentPane.add(lblNewLabel_1_3);
		
		lblMatutino = new JLabel("0");
		lblMatutino.setBounds(280, 535, 94, 13);
		contentPane.add(lblMatutino);
		
		JLabel lblNewLabel_1_4 = new JLabel("Matutino:");
		lblNewLabel_1_4.setBounds(197, 535, 73, 13);
		contentPane.add(lblNewLabel_1_4);
		
		lblVespertino = new JLabel("0");
		lblVespertino.setBounds(280, 558, 94, 13);
		contentPane.add(lblVespertino);
		
		JLabel lblNewLabel_1_5 = new JLabel("Vespertino:");
		lblNewLabel_1_5.setBounds(197, 558, 73, 13);
		contentPane.add(lblNewLabel_1_5);
		
		lblNoturno = new JLabel("0");
		lblNoturno.setBounds(280, 581, 94, 13);
		contentPane.add(lblNoturno);
		
		JLabel lblNewLabel_1_6 = new JLabel("Noturno:");
		lblNewLabel_1_6.setBounds(197, 581, 73, 13);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2 = new JLabel("Alunos por turno:");
		lblNewLabel_2.setBounds(197, 512, 158, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Total de Alunos:");
		lblNewLabel_1_6_1.setBounds(10, 621, 124, 13);
		contentPane.add(lblNewLabel_1_6_1);
		
		lblTotalAlunos = new JLabel("0");
		lblTotalAlunos.setBounds(144, 621, 94, 13);
		contentPane.add(lblTotalAlunos);
		
		atualizarAlunos();
	}
	
	private void atualizarEstatisticas() {
		List<Aluno> alunos = AcoesAluno.selectAll();
		
		int totalAlunos = 0;
		int aprovados = 0;
		int reprovados = 0;
		int homens = 0;
		int mulheres = 0;
		int vespertinos = 0;
		int matutinos = 0;
		int noturnos = 0;
		
		for (Aluno a : alunos) {
			totalAlunos++;
			
			if (a.getSituacao().equals("Aprovado")) aprovados++;
			else reprovados++;
			
			if (a.getGenero() == 'm') homens++;
			else mulheres++;
			
			if (a.getTurno() == 'm') matutinos++;
			if (a.getTurno() == 'v') vespertinos++;
			if (a.getTurno() == 'n') noturnos++;
		}
		
		lblTotalAlunos.setText(totalAlunos + "");
		lblAprovados.setText(aprovados + "");
		lblReprovados.setText(reprovados + "");
		lblHomens.setText(homens + "");
		lblMulheres.setText(mulheres + "");
		lblMatutino.setText(matutinos + "");
		lblVespertino.setText(vespertinos + "");
		lblNoturno.setText(noturnos + "");
	}
	
	private void remover() {
		int id = getIdSelecionado();
		
		if (id < 0) return;
		
		AcoesAluno.remover(id);
		atualizarAlunos();
		JOptionPane.showMessageDialog(null, "Aluno Removido!");
	}
	
	private void editar() {
		int id = getIdSelecionado();
		
		if (id < 0) return;
		
		TelaEditar telaEditar = new TelaEditar(id);
		telaEditar.setVisible(true);
		fechar();
	}
	
	private void atualizarAlunos() {
		DefaultTableModel dtm = new DefaultTableModel();
		
		dtm.addColumn("Codigo");
		dtm.addColumn("Nome");
		dtm.addColumn("Nota 1");
		dtm.addColumn("Nota 2");
		dtm.addColumn("Média");
		dtm.addColumn("Situação");
		dtm.addColumn("Turno");
		dtm.addColumn("Gênero");
		
		List<Aluno> alunos = AcoesAluno.selectAll();
		
		comboAlunos.removeAllItems();
		comboAlunos.addItem("Selecione um aluno:");
		
		for (Aluno a : alunos) {
			dtm.addRow(new String[] {
					a.getId() + "", a.getNome(),
					a.getNota1() + "", a.getNota2() + "",
					a.getMedia() + "",
					a.getSituacao(),
					a.getTurnoExtenso(),
					a.getGeneroExtenso()
			});
			comboAlunos.addItem(a.getId() + " - " + a.getNome());
		}
		
		table.setModel(dtm);
		atualizarEstatisticas();
	}
	
	private int getIdSelecionado() {
		if (comboAlunos.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um aluno!");
			return -1;
		}
		
		int id = Integer.parseInt(
				comboAlunos.getSelectedItem().toString().split(" -")[0]);
		
		return id;
	}
	
	private void fechar() {
		this.dispose();
	}
}
