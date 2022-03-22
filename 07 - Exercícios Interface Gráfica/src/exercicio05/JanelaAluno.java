package exercicio05;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAluno extends JFrame {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblGenero;
	private int indiceAluno;

	/**
	 * Create the frame.
	 */
	public JanelaAluno(int indiceAluno) {
		this.indiceAluno = indiceAluno;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 33, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setBounds(10, 56, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00EAnero:");
		lblNewLabel_2.setBounds(10, 79, 62, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaInformacoesAluno janela = new JanelaInformacoesAluno(indiceAluno);
				janela.setVisible(true);
				fechar();
			}
		});
		btnAlterarDados.setBounds(10, 142, 123, 21);
		contentPane.add(btnAlterarDados);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaLogin login = new JanelaLogin();
				login.setVisible(true);
				fechar();
			}
		});
		btnLogout.setBounds(143, 142, 85, 21);
		contentPane.add(btnLogout);
		
		lblNome = new JLabel("");
		lblNome.setBounds(102, 33, 45, 13);
		contentPane.add(lblNome);
		
		lblIdade = new JLabel("");
		lblIdade.setBounds(102, 56, 45, 13);
		contentPane.add(lblIdade);
		
		lblGenero = new JLabel("");
		lblGenero.setBounds(102, 79, 45, 13);
		contentPane.add(lblGenero);
		
		atualizar();
	}
	
	private void fechar() {
		this.dispose();
	}
	
	private void atualizar() {
		Aluno a = Dados.alunos.get(indiceAluno);
		lblNome.setText(a.getNome());
		lblIdade.setText(a.getIdade() + "");
		lblGenero.setText(a.getSexo());
	}

}
