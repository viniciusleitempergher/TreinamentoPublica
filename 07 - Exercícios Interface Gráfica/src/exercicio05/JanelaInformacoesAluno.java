package exercicio05;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaInformacoesAluno extends JFrame {

	private JPanel contentPane;
	private int indiceAluno;
	private JTextField txtNome;
	private JTextField txtIdade;

	/**
	 * Create the frame.
	 */
	public JanelaInformacoesAluno(int indiceAluno) {
		this.indiceAluno = indiceAluno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 199, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 28, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 51, 165, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 80, 45, 13);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(10, 103, 165, 19);
		contentPane.add(txtIdade);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 132, 45, 13);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(10, 151, 103, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(10, 174, 103, 21);
		contentPane.add(rdbtnFeminino);
		
		ButtonGroup group = new ButtonGroup();;
		group.add(rdbtnMasculino);
		group.add(rdbtnFeminino);
		
		JButton btnOk = new JButton("Ok!");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					group.getSelection().getActionCommand();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Marque um gênero!");
					return;
				}
				
				if (indiceAluno == -1) {
					Aluno a = new Aluno();
					
					a.setNome(txtNome.getText());
					a.setIdade(Integer.parseInt(txtIdade.getText()));					
					a.setSexo(rdbtnMasculino.isSelected() ? "M" : "F");
					
					Dados.alunos.add(a);
					
					if (Dados.professor) {
						JanelaProfessor janelaProfessor = new JanelaProfessor();
						janelaProfessor.setVisible(true);
					} else {
						// TODO abrir do aluno
					}
					fechar();
				} else {
					
				}
			}
		});
		btnOk.setBounds(10, 202, 165, 21);
		contentPane.add(btnOk);
	}
	
	private void fechar() {
		this.dispose();
	}
}
