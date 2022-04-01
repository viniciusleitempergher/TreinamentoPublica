package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AcoesAluno;
import entidade.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JComboBox<String> comboBoxTurno;
	private JComboBox<String> comboBoxGenero;

	/**
	 * Create the frame.
	 */
	public TelaEditar(final int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 33, 224, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(10, 85, 224, 19);
		contentPane.add(txtNota1);
		
		JLabel lblNota = new JLabel("Nota 1");
		lblNota.setBounds(10, 62, 45, 13);
		contentPane.add(lblNota);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(10, 137, 224, 19);
		contentPane.add(txtNota2);
		
		JLabel lblNota_1 = new JLabel("Nota 2");
		lblNota_1.setBounds(10, 114, 45, 13);
		contentPane.add(lblNota_1);
		
		comboBoxTurno = new JComboBox<String>();
		comboBoxTurno.setBounds(10, 195, 224, 21);
		contentPane.add(comboBoxTurno);
		
		JLabel lblNewLabel_1 = new JLabel("Turno");
		lblNewLabel_1.setBounds(10, 172, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("G\u00EAnero");
		lblNewLabel_1_1.setBounds(10, 226, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setBounds(10, 249, 224, 21);
		contentPane.add(comboBoxGenero);
		
		JButton btnCadastrar = new JButton("Editar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar(id);
			}
		});
		btnCadastrar.setBounds(10, 293, 224, 21);
		contentPane.add(btnCadastrar);
		
		comboBoxTurno.addItem("Matutino");
		comboBoxTurno.addItem("Vespertino");
		comboBoxTurno.addItem("Noturno");
		
		comboBoxGenero.addItem("Masculino");
		comboBoxGenero.addItem("Feminino");
		
		Aluno a = AcoesAluno.findById(id);
		txtNome.setText(a.getNome());
		txtNota1.setText(a.getNota1() + "");
		txtNota2.setText(a.getNota2() + "");
		
		comboBoxGenero.setSelectedIndex(a.getGenero() == 'm' ? 0 : 1);
		comboBoxTurno.setSelectedIndex(a.getTurno() == 'm' ? 0 : 
			a.getTurno() == 'v' ? 1 : 2);
	}
	
	private void editar(int id) {
		Aluno a = getAlunoFormulario();
		
		a.setId(id);
		
		AcoesAluno.alterar(a);
		JOptionPane.showMessageDialog(null, "Aluno editado!");
		fechar();
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}
	
	private Aluno getAlunoFormulario() {
		if (txtNome.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o nome!");
			return null;
		}
		double nota1 = Validator.validarDouble(txtNota1.getText());
		double nota2 = Validator.validarDouble(txtNota2.getText());
		
		if (nota1 < 0 || nota2 < 0) {
			JOptionPane.showMessageDialog(null, "Preencha as notas corretamente!");
		}
		
		Aluno a = new Aluno();
		a.setNome(txtNome.getText());
		a.setGenero(comboBoxGenero.getSelectedItem().toString().toLowerCase().charAt(0));
		a.setTurno(comboBoxTurno.getSelectedItem().toString().toLowerCase().charAt(0));
		a.setNota1(nota1);
		a.setNota2(nota2);
		
		return a;
	}
	
	private void fechar() {
		this.dispose();
	}
}
