package exercicio06;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JanelaJogo extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnAlternativa0;
	private JRadioButton rdbtnAlternativa1;
	private JRadioButton rdbtnAlternativa2;	
	private JLabel lblAcertos;
	private JLabel lblErros;
	private JLabel lblPosicaoRanking;
	private JLabel lblPergunta;
	
	private ArrayList<Pergunta> perguntas;
	private int perguntaAtual = 0;
	private int acertos = 0;
	private int erros = 0;	

	/**
	 * Create the frame.
	 */
	public JanelaJogo(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPergunta = new JLabel("Pergunta?");
		lblPergunta.setBounds(10, 25, 527, 29);
		contentPane.add(lblPergunta);
		
		rdbtnAlternativa0 = new JRadioButton("alternativa 1");
		rdbtnAlternativa0.setBounds(10, 60, 103, 21);
		rdbtnAlternativa0.setActionCommand("alt0");
		contentPane.add(rdbtnAlternativa0);
		
		rdbtnAlternativa1 = new JRadioButton("alternativa 2");
		rdbtnAlternativa1.setActionCommand("alt1");
		rdbtnAlternativa1.setBounds(10, 83, 103, 21);
		contentPane.add(rdbtnAlternativa1);
		
		rdbtnAlternativa2 = new JRadioButton("alternativa 3");
		rdbtnAlternativa2.setActionCommand("alt2");
		rdbtnAlternativa2.setBounds(10, 106, 103, 21);
		contentPane.add(rdbtnAlternativa2);
		
		JLabel lblTxtAcertos = new JLabel("Acertos");
		lblTxtAcertos.setBounds(10, 197, 45, 13);
		contentPane.add(lblTxtAcertos);
		
		JLabel lblTxtErros = new JLabel("Erros");
		lblTxtErros.setBounds(10, 220, 45, 13);
		contentPane.add(lblTxtErros);
		
		lblAcertos = new JLabel("0");
		lblAcertos.setBounds(79, 197, 45, 13);
		contentPane.add(lblAcertos);
		
		lblErros = new JLabel("0");
		lblErros.setBounds(79, 220, 45, 13);
		contentPane.add(lblErros);
		
		JLabel lblTxtPosicao = new JLabel("Posicao no ranking:");
		lblTxtPosicao.setBounds(282, 197, 127, 13);
		contentPane.add(lblTxtPosicao);
		
		lblPosicaoRanking = new JLabel("1");
		lblPosicaoRanking.setBounds(419, 197, 45, 13);
		contentPane.add(lblPosicaoRanking);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAlternativa0);
		group.add(rdbtnAlternativa1);
		group.add(rdbtnAlternativa2);
		
		JButton btnNewButton = new JButton("Responder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pergunta pergunta = perguntas.get(perguntaAtual);
				
				if (group.getSelection().getActionCommand().equals("alt0")) {
					if (pergunta.getIndiceResposta() == 0) {
						acertos++;
					} else {
						erros++;
					}
				}
				if (group.getSelection().getActionCommand().equals("alt1")) {
					if (pergunta.getIndiceResposta() == 1) {
						acertos++;
					} else {
						erros++;
					}
				}
				if (group.getSelection().getActionCommand().equals("alt2")) {
					if (pergunta.getIndiceResposta() == 2) {
						acertos++;
					} else {
						erros++;
					}
				}
				
				pergunta.getIndiceResposta();
				
				if (++perguntaAtual > 4) {
					JOptionPane.showMessageDialog(null, "Você terminou o jogo!");
					return;
				}			
				
				atualizar();
			}
		});
		btnNewButton.setBounds(10, 154, 527, 21);
		contentPane.add(btnNewButton);
		
		atualizar();
	}

	private void atualizar() {
		Pergunta p = perguntas.get(perguntaAtual);
		lblPergunta.setText(p.getTexto());
		rdbtnAlternativa0.setText(p.getAlternativas()[0]);
		rdbtnAlternativa1.setText(p.getAlternativas()[1]);
		rdbtnAlternativa2.setText(p.getAlternativas()[2]);
	}
}
