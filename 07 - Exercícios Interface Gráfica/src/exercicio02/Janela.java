package exercicio02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private ButtonGroup moedas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 198, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor = new JLabel("Informe o valor em reais");
		lblValor.setBounds(10, 29, 162, 13);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(10, 52, 162, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblTextoResultado = new JLabel("Resultado");
		lblTextoResultado.setBounds(10, 234, 90, 13);
		contentPane.add(lblTextoResultado);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setBounds(10, 255, 162, 40);
		contentPane.add(lblResultado);
		
		JRadioButton rdbtnDolar = new JRadioButton("D\u00F3lar");
		rdbtnDolar.setActionCommand("dolar");
		rdbtnDolar.setBounds(10, 77, 103, 21);
		contentPane.add(rdbtnDolar);
		
		JRadioButton rdbtnEuro = new JRadioButton("Euro");
		rdbtnEuro.setActionCommand("euro");
		rdbtnEuro.setBounds(10, 100, 103, 21);
		contentPane.add(rdbtnEuro);
		
		JRadioButton rdbtnLibra = new JRadioButton("Libra");
		rdbtnLibra.setActionCommand("libra");
		rdbtnLibra.setBounds(10, 123, 103, 21);
		contentPane.add(rdbtnLibra);
		
		JRadioButton rdbtnLeneJapones = new JRadioButton("Lene Japon\u00EAs");
		rdbtnLeneJapones.setActionCommand("leneJapones");
		rdbtnLeneJapones.setBounds(10, 146, 142, 21);
		contentPane.add(rdbtnLeneJapones);
		
		JRadioButton rdbtnPesoArgentino = new JRadioButton("Peso Argentino");
		rdbtnPesoArgentino.setActionCommand("pesoArgentino");
		rdbtnPesoArgentino.setBounds(10, 169, 142, 21);
		contentPane.add(rdbtnPesoArgentino);
		
		moedas = new ButtonGroup();
		moedas.add(rdbtnDolar);
		moedas.add(rdbtnEuro);
		moedas.add(rdbtnLibra);
		moedas.add(rdbtnLeneJapones);
		moedas.add(rdbtnPesoArgentino);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String moeda = moedas.getSelection().getActionCommand();
				double valor = Double.parseDouble(txtValor.getText());
				double resultado = 0;
				
				if (moeda.equals("dolar")) {
					resultado = valor / 4.97;
				}
				if (moeda.equals("euro")) {
					resultado = valor / 5.48;
				}
				if (moeda.equals("libra")) {
					resultado = valor / 6.55;
				}
				if (moeda.equals("leneJapones")) {
					resultado = valor / 0.042;
				}
				if (moeda.equals("pesoArgentino")) {
					resultado = valor / 0.045;
				}
				
				lblResultado.setText("" + resultado);
			}
		});
		btnNewButton.setBounds(10, 203, 162, 21);
		contentPane.add(btnNewButton);
	}

}
