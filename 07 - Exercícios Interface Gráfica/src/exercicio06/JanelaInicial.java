package exercicio06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class JanelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Preenchedor.cadastrarMatematica();
		Preenchedor.cadastrarPortugues();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInicial frame = new JanelaInicial();
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
	public JanelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 161, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o seu nome");
		lblNewLabel.setBounds(10, 25, 126, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 126, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnMatematica = new JRadioButton("Matem\u00E1tica");
		rdbtnMatematica.setBounds(10, 73, 103, 21);
		rdbtnMatematica.setActionCommand("matematica");
		contentPane.add(rdbtnMatematica);
		
		JRadioButton rdbtnPortugues = new JRadioButton("Portugu\u00EAs");
		rdbtnPortugues.setBounds(10, 96, 103, 21);
		rdbtnPortugues.setActionCommand("portugues");
		contentPane.add(rdbtnPortugues);
		
		JRadioButton rdbtnGeografia = new JRadioButton("Geografia");
		rdbtnGeografia.setBounds(10, 119, 103, 21);
		rdbtnGeografia.setActionCommand("geografia");
		contentPane.add(rdbtnGeografia);
		
		JRadioButton rdbtnHistoria = new JRadioButton("Hist\u00F3ria");
		rdbtnHistoria.setBounds(10, 142, 103, 21);
		rdbtnHistoria.setActionCommand("historia");
		contentPane.add(rdbtnHistoria);
		
		JRadioButton rdbtnAssuntosGerais = new JRadioButton("Assuntos gerais");
		rdbtnAssuntosGerais.setBounds(10, 165, 126, 21);
		rdbtnAssuntosGerais.setActionCommand("assuntosGerais");
		contentPane.add(rdbtnAssuntosGerais);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMatematica);
		group.add(rdbtnPortugues);
		group.add(rdbtnGeografia);
		group.add(rdbtnHistoria);
		group.add(rdbtnAssuntosGerais);
		
		JButton btnIniciar = new JButton("Ok!");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pergunta> perguntasSorteadas = new ArrayList<>();
				
				String opcao = group.getSelection().getActionCommand();
				
				if (opcao.equals("matematica")) {
					perguntasSorteadas = sortearPerguntas(Dados.perguntasMatematica);
				}
				if (opcao.equals("portugues")) {
					perguntasSorteadas = sortearPerguntas(Dados.perguntasPortugues);
				}
				if (opcao.equals("geografia")) {
					perguntasSorteadas = sortearPerguntas(Dados.perguntasGeografia);
				}
				if (opcao.equals("historia")) {
					perguntasSorteadas = sortearPerguntas(Dados.perguntasHistoria);
				}
				if (opcao.equals("assuntosGerais")) {
					perguntasSorteadas = sortearPerguntas(Dados.perguntasAssuntosGerais);
				}
				
				JanelaJogo telaJogo = new JanelaJogo(perguntasSorteadas);
				telaJogo.setVisible(true);
				fechar();
			}
		});
		btnIniciar.setBounds(10, 232, 126, 21);
		contentPane.add(btnIniciar);
	}
	
	private void fechar() {
		this.dispose();
	}
	
	private ArrayList<Pergunta> sortearPerguntas(ArrayList<Pergunta> perguntasParaSortear) {
		ArrayList<Integer> sorteados = new ArrayList<>();
		ArrayList<Pergunta> perguntasSorteadas = new ArrayList<>();
		Random aleatorio = new Random();
		
		for (int i = 0; i < 5; i++) {
			int sorteado = aleatorio.nextInt(perguntasParaSortear.size());
			if (sorteados.contains(sorteado)) {
				i--;
				continue;
			}
			sorteados.add(sorteado);
			perguntasSorteadas.add(perguntasParaSortear.get(sorteado));
		}
		
		return perguntasSorteadas;
	}
}
