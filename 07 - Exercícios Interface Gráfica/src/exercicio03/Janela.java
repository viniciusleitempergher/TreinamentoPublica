package exercicio03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtPeso;

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
		setBounds(100, 100, 135, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 26, 45, 13);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 80, 45, 13);
		contentPane.add(lblPeso);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(10, 49, 96, 19);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(10, 103, 96, 19);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblTextoResultado = new JLabel("Resultado");
		lblTextoResultado.setBounds(10, 177, 96, 13);
		contentPane.add(lblTextoResultado);
		
		JLabel lblImc = new JLabel("");
		lblImc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImc.setBounds(10, 200, 96, 21);
		contentPane.add(lblImc);
		
		JLabel lblSituacao = new JLabel("");
		lblSituacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSituacao.setBounds(10, 231, 96, 19);
		contentPane.add(lblSituacao);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double peso = Double.parseDouble(txtPeso.getText());
				double altura = Double.parseDouble(txtAltura.getText());
				
				double imc = peso / (altura * altura);
				
				String imcTxt = "IMC: " + imc;
				String situacao = "";
				
				if (imc < 18.5) {
					situacao += "Abaixo do peso.";
				} else if (imc < 25) {
					situacao += "Peso normal.";
				} else if (imc < 30) {
					situacao += "Acima do peso.";
				} else if (imc < 35) {
					situacao += "Obesidade 1.";
				} else if (imc < 40) {
					situacao += "Obesidade 2.";
				} else {
					situacao += "Obesidade 3.";
				}
				
				lblImc.setText(imcTxt);
				lblSituacao.setText(situacao);
			}
		});
		btnCalcular.setBounds(10, 146, 96, 21);
		contentPane.add(btnCalcular);
	}

}
