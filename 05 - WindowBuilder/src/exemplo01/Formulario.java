package exemplo01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRetorno = new JLabel("New label");
		lblRetorno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetorno.setBounds(10, 200, 426, 37);
		contentPane.add(lblRetorno);
		
		JButton btnEnviar = new JButton("Clique Aqui");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRetorno.setText(txtCampo.getText());
			}
		});
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setBackground(new Color(0, 102, 153));
		btnEnviar.setBounds(149, 159, 133, 21);
		contentPane.add(btnEnviar);
		
		txtCampo = new JTextField();
		txtCampo.setBounds(198, 93, 84, 29);
		contentPane.add(txtCampo);
		txtCampo.setColumns(10);
		
		JLabel lblCampo = new JLabel("Digite Algo:");
		lblCampo.setBounds(117, 101, 71, 13);
		contentPane.add(lblCampo);
	}
}
