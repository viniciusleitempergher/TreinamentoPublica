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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaProfessor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public JanelaProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Editar Aluno");
		btnNewButton_1.setBounds(221, 62, 129, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover Aluno");
		btnNewButton_2.setBounds(360, 62, 129, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnAdicionarProva = new JButton("Adicionar Prova");
		btnAdicionarProva.setBounds(534, 31, 129, 21);
		contentPane.add(btnAdicionarProva);
		
		JButton btnAdicionarNotas = new JButton("Adicionar Notas");
		btnAdicionarNotas.setBounds(534, 62, 129, 21);
		contentPane.add(btnAdicionarNotas);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.setBounds(534, 94, 129, 21);
		contentPane.add(btnChamada);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(10, 62, 201, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 719, 288);
		contentPane.add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Sexo");
		dtm.addColumn("Idade");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(534, 125, 129, 21);
		contentPane.add(btnLogout);
		
		JButton btnNewButton = new JButton("Adicionar Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaInformacoesAluno janelaCadastro = new JanelaInformacoesAluno(-1);
				janelaCadastro.setVisible(true);
				fechar();
			}
		});
		btnNewButton.setBounds(360, 31, 129, 21);
		contentPane.add(btnNewButton);
		
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
		
		int homens = 0;
		int mulheres = 0;
		
		for (Aluno a : Dados.alunos) {
			dtm.addRow(new Object[] {
					a.getNome(), a.getIdade(), a.getSexo()
			});
			if (a.getSexo().equals("M")) homens++;
			else mulheres++;
		}
		
		dtm.addRow(new Object[] {
				"Média da Turma", // TODO
		});
		dtm.addRow(new Object[] {
				"Quantidade de meninos", homens
		});
		dtm.addRow(new Object[] {
				"Quantidade de meninas", mulheres
		});
		dtm.addRow(new Object[] {
				"Quantidade de alunos com média 7 ou mais", 0 // TODO
		});
		dtm.addRow(new Object[] {
				"Quantidade de alunos com média menor que 7", 0 // TODO
		});
		
		table.setModel(dtm);
	}

}
