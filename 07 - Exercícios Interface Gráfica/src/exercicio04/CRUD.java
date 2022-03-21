package exercicio04;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CRUD {
	private static ArrayList<Produto> produtos = new ArrayList<>();
	
	public static void cadastrar(Produto p) {
		produtos.add(p);
	}
	
	public static void alterar(int indice, Produto p) {
		produtos.set(indice, p);
	}
	
	public static void remover(int indice) {
		produtos.remove(indice);
	}
	
	public static ArrayList<Produto> listar() {
		return produtos;
	}
	
	public static DefaultTableModel montarTabela() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Marca");
		dtm.addColumn("Segmento");
		dtm.addColumn("Valor");
		
		for (int i = 0; i < produtos.size(); i++) {
			dtm.addRow(new Object[] {
				produtos.get(i).getNome(),
				produtos.get(i).getMarca(),
				produtos.get(i).getSegmento(),
				produtos.get(i).getValor(),
			});
		}
		
		return dtm;
	}
}
