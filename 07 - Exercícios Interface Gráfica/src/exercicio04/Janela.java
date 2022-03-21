package exercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtMarca;
	private JTextField txtSegmento;
	private JTextField txtValor;
	private JButton btnCadastrar;
	private JComboBox<String> comboBox;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JScrollPane scrollPane;
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
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produto:");
		lblNewLabel.setBounds(10, 10, 81, 13);
		contentPane.add(lblNewLabel);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(101, 10, 96, 19);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(101, 36, 96, 19);
		contentPane.add(txtMarca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 36, 81, 13);
		contentPane.add(lblMarca);
		
		txtSegmento = new JTextField();
		txtSegmento.setColumns(10);
		txtSegmento.setBounds(101, 65, 96, 19);
		contentPane.add(txtSegmento);
		
		JLabel lblSegmento = new JLabel("Segmento:");
		lblSegmento.setBounds(10, 65, 81, 13);
		contentPane.add(lblSegmento);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 94, 81, 13);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(101, 94, 96, 19);
		contentPane.add(txtValor);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(10, 133, 187, 21);
		contentPane.add(comboBox);
		comboBox.addItem("Selecione um produto:");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 416, 201);
		contentPane.add(scrollPane);
		
		table = new JTable(CRUD.montarTabela());
		scrollPane.setViewportView(table);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto();
				p.setNome(txtProduto.getText());
				p.setMarca(txtMarca.getText());
				p.setSegmento(txtSegmento.getText());
				p.setValor(Double.parseDouble(txtValor.getText()));
				
				CRUD.cadastrar(p);
				comboBox.addItem(p.getNome());
				atualizarTabela();
			}
		});
		btnCadastrar.setBounds(226, 93, 200, 21);
		contentPane.add(btnCadastrar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escolha um produto!");
					return;
				}
				CRUD.remover(comboBox.getSelectedIndex() - 1);
				comboBox.removeItemAt(comboBox.getSelectedIndex());
				atualizarTabela();
			}
		});
		btnRemover.setBounds(321, 133, 105, 21);
		contentPane.add(btnRemover);
		
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escolha um produto!");
					return;
				}
				
				Produto p = new Produto();
				p.setNome(txtProduto.getText());
				p.setMarca(txtMarca.getText());
				p.setSegmento(txtSegmento.getText());
				p.setValor(Double.parseDouble(txtValor.getText()));
				
				CRUD.remover(comboBox.getSelectedIndex() - 1);
				CRUD.cadastrar(p);
				comboBox.removeItemAt(comboBox.getSelectedIndex());
				comboBox.addItem(p.getNome());
				atualizarTabela();
			}
		});
		btnAlterar.setBounds(226, 133, 85, 21);
		contentPane.add(btnAlterar);
	}

	private void atualizarTabela() {
		table.setModel(CRUD.montarTabela());
	}
}
