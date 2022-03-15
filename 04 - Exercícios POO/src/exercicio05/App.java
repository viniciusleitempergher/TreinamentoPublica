package exercicio05;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
	public void iniciar() throws IOException {
		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar Produto",
					"Editar Produto",
					"Remover Produto",
					"Listar Produtos",
	                "Sair"
	                };
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			
			switch (opcao) {
			case 0:
				String nome = JOptionPane.showInputDialog("Digite o nome:");
				String marca = JOptionPane.showInputDialog("Digite a marca:");
				Double valor = Double.parseDouble(
						JOptionPane.showInputDialog("Digite o valor:")
						);
				Leitor.gravarProduto(new Produto(nome, marca, valor));
				JOptionPane.showMessageDialog(null, "Cadastrado!");
				break;
			case 1:
				nome = JOptionPane.showInputDialog("Digite o nome do produto a ser editado:");
				String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
				marca = JOptionPane.showInputDialog("Digite a marca:");
				valor = Double.parseDouble(
						JOptionPane.showInputDialog("Digite o valor:")
						);
				Leitor.editarProduto(nome, new Produto(novoNome, marca, valor));
				break;
			case 2:
				nome = JOptionPane.showInputDialog("Digite o nome do produto a ser removido:");
				Leitor.deletarProduto(nome);
				JOptionPane.showMessageDialog(null, "Deletado!");
				break;
			case 3:
				String saidaProdutos = "";
				ArrayList<Produto> produtos = Leitor.listarProdutos();
				for (Produto p : produtos) {
					saidaProdutos += "Nome: " + p.getNome() + "\nMarca: "
							+ p.getMarca() + "\nValor: " + p.getValor() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, saidaProdutos);
				break;
			case 4:
				break infinito;
			}
		}
	}
}
