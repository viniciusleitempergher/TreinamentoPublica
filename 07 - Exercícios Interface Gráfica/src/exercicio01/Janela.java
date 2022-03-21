package exercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTable table;

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
		setBounds(100, 100, 155, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTexto = new JLabel("Digite um n\u00FAmero:");
		lblTexto.setBounds(20, 32, 111, 13);
		contentPane.add(lblTexto);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(20, 65, 100, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Cálculo");
		dtm.addColumn("Resultado");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				int numero = Integer.parseInt(txtNumero.getText()); 
				
				for (int i = 1; i <= 10; i++) {
					dtm.addRow(new Object[] {
						numero + " * " + i,
						numero * i
					});
				}
				
				table.setModel(dtm);
			}
		});
		btnCalcular.setBounds(20, 94, 100, 21);
		contentPane.add(btnCalcular);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 121, 204);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}
}
