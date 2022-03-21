package acoes;

import javax.swing.table.DefaultTableModel;

import db.Dados;
import modelo.Cliente;

public class AcaoCliente {
	
	// Cadastro
	public static void cadastrar(Cliente obj) {	
		Dados.clientes.add(obj);
	}
	
	// Lista de Clientes
	public static DefaultTableModel listar() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Email");
		dtm.addColumn("Cidade");
		
		for (int i = 0; i < Dados.clientes.size(); i++) {
			dtm.addRow(new Object[] {
					Dados.clientes.get(i).getNome(),
					Dados.clientes.get(i).getEmail(),
					Dados.clientes.get(i).getCidade(),
			});
		}
		
		return dtm;
	}
}
