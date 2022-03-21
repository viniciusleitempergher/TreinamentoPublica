package exemplo03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setBounds(6, 24, 74, 21);
		rdbtnJava.setActionCommand("Java");
		contentPane.add(rdbtnJava);
		
		JRadioButton rdbtnCs = new JRadioButton("C#");
		rdbtnCs.setBounds(94, 24, 74, 21);
		rdbtnCs.setActionCommand("C#");
		contentPane.add(rdbtnCs);
		
		JRadioButton rdbtnPhp = new JRadioButton("PHP");
		rdbtnPhp.setBounds(198, 24, 74, 21);
		rdbtnPhp.setActionCommand("PHP");
		contentPane.add(rdbtnPhp);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnJava);
		grupo.add(rdbtnCs);
		grupo.add(rdbtnPhp);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(grupo.getSelection().getActionCommand());
			}
		});
		btnEnviar.setBounds(80, 111, 129, 21);
		contentPane.add(btnEnviar);
	}
}
