package exercicio05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin frame = new JanelaLogin();
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
	public JanelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 222, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 58, 183, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 35, 45, 13);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnSouAluno = new JRadioButton("Sou aluno");
		rdbtnSouAluno.setBounds(10, 83, 151, 21);
		rdbtnSouAluno.setActionCommand("aluno");
		contentPane.add(rdbtnSouAluno);
		
		JRadioButton rdbtnSouProfessor = new JRadioButton("Sou professor");
		rdbtnSouProfessor.setBounds(10, 106, 151, 21);
		rdbtnSouProfessor.setActionCommand("professor");
		contentPane.add(rdbtnSouProfessor);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSouAluno);
		group.add(rdbtnSouProfessor);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selecao = "";
				try {
					selecao = group.getSelection().getActionCommand();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Selecione se � aluno ou professor!");
				}
				if (selecao.equals("aluno")) {
					for (Aluno a : Dados.alunos) {
						if (a.getNome().equals(txtNome.getText())) {
							// TODO Abrir tela do aluno
						}
					}
				} 
				if (selecao.equals("professor")) {
					Dados.professor = true;
					fecharLogin();
					JanelaProfessor telaProfessor = new JanelaProfessor();
					telaProfessor.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(52, 145, 85, 21);
		contentPane.add(btnEntrar);
	}
	
	public void fecharLogin() {
		this.dispose();
	}

}
