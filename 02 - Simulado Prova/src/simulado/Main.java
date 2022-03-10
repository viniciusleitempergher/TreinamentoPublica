package simulado;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> nomesProdutos = new ArrayList<>();
		ArrayList<Double> valoresProdutos = new ArrayList<>();
		ArrayList<Integer> segmentosProdutos = new ArrayList<>();
		
		String[] segmentos = {
				"Áudio e vídeo", "Alimentício", "Eletrodomésticos", "Informática", "Vestuário"
		};
		double[] valoresSegmentosMunicipal = {
				0.03, 0.01, 0.03, 0.04, 0.02
		};
		double[] valoresSegmentosEstadual = {
				0.05, 0.03, 0.08, 0.10, 0.03
		};
		double[] valoresSegmentosFederal = {
				0.07, 0.06, 0.09, 0.16, 0.05
		};
		
		DecimalFormat df = new DecimalFormat("0.00");

		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar",
	                "Listar",
	                "Listar por segmento",
	                "Alterar",
	                "Remover",
	                "Estatísticas",
	                "Sair"
	                };
			
			int opcao = JOptionPane.showOptionDialog(null,
				"Escolha uma opção:",
				"Sistema de Impostos",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[6]
			);
			
			switch(opcao) {
			case 0: 
				String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
				if (nomesProdutos.contains(nome)) {
					JOptionPane.showMessageDialog(null, "Esse nome já foi cadastrado!");
					break;
				}
				nomesProdutos.add(nome);
				
				try {
					valoresProdutos.add(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:")));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor deve ser um número, com os centavos separados por ponto!\nEx: 10.50");
				}
				
				segmentosProdutos.add(JOptionPane.showOptionDialog(null,
						"Escolha o segmento:",
						"Segmentos",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						segmentos,
						segmentos[0]
					));
				
				JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
				break;
			case 1:
				for (int i = 0; i < nomesProdutos.size(); i++) {
					double valorImpostoMunicipal = valoresProdutos.get(i) * valoresSegmentosMunicipal[segmentosProdutos.get(i)];
					double valorImpostoEstadual = valoresProdutos.get(i) * valoresSegmentosEstadual[segmentosProdutos.get(i)];
					double valorImpostoFederal = valoresProdutos.get(i) * valoresSegmentosFederal[segmentosProdutos.get(i)];
					
					JOptionPane.showMessageDialog(null, "\nNome: " + nomesProdutos.get(i)
						+ "\nValor sem impostos: " + valoresProdutos.get(i)
						+ "\nSegmento: " + segmentos[segmentosProdutos.get(i)]
						+ "\nValor do imposto muncipal: " + df.format(valorImpostoMunicipal)
						+ "\nValor do imposto estadual: " + df.format(valorImpostoEstadual)
						+ "\nValor do imposto federal: " + df.format(valorImpostoFederal)
						+ "\nValor total: " + 
						df.format(valoresProdutos.get(i) + valorImpostoMunicipal + valorImpostoEstadual + valorImpostoFederal));
				}
				
				if (nomesProdutos.size() == 0) JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
				
				break;
			case 2:
				int segmentoEscolhido = JOptionPane.showOptionDialog(null,
						"Escolha o segmento:",
						"Segmentos",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						segmentos,
						segmentos[0]
				);
				
				boolean temProdutos = false;
				
				for (int i = 0; i < nomesProdutos.size(); i++) {
					if (segmentosProdutos.get(i) != segmentoEscolhido) continue;
					
					temProdutos = true;
					
					double valorImpostoMunicipal = valoresProdutos.get(i) * valoresSegmentosMunicipal[segmentosProdutos.get(i)];
					double valorImpostoEstadual = valoresProdutos.get(i) * valoresSegmentosEstadual[segmentosProdutos.get(i)];
					double valorImpostoFederal = valoresProdutos.get(i) * valoresSegmentosFederal[segmentosProdutos.get(i)];
					
					JOptionPane.showMessageDialog(null, "\nNome: " + nomesProdutos.get(i)
						+ "\nValor sem impostos: " + valoresProdutos.get(i)
						+ "\nSegmento: " + segmentos[segmentosProdutos.get(i)]
						+ "\nValor do imposto muncipal: " + df.format(valorImpostoMunicipal)
						+ "\nValor do imposto estadual: " + df.format(valorImpostoEstadual)
						+ "\nValor do imposto federal: " + df.format(valorImpostoFederal)
						+ "\nValor total: " + 
						df.format(valoresProdutos.get(i) + valorImpostoMunicipal + valorImpostoEstadual + valorImpostoFederal));
				}
				
				if (!temProdutos) JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado neste segmento!");
				
				break;
			case 3:
				String pesquisa = JOptionPane.showInputDialog("Digite o nome do produto que deseja alterar:");
				
				int indiceProduto = nomesProdutos.indexOf(pesquisa);
				
				if (indiceProduto < 0) {
					JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado com este nome.");
					break;
				}
				
				nome = JOptionPane.showInputDialog("Digite o novo nome do produto:");
				nomesProdutos.set(indiceProduto, "");
				if (nomesProdutos.contains(nome)) {
					JOptionPane.showMessageDialog(null, "Esse nome já foi cadastrado!");
					nomesProdutos.set(indiceProduto, pesquisa);
					break;
				}
				nomesProdutos.set(indiceProduto, nome);
				
				try {
					valoresProdutos.set(indiceProduto, Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:")));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor deve ser um número, com os centavos separados por ponto!\nEx: 10.50");
				}
				
				segmentosProdutos.set(indiceProduto, JOptionPane.showOptionDialog(null,
						"Escolha o segmento:",
						"Segmentos",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						segmentos,
						segmentos[0]
					));
				
				JOptionPane.showMessageDialog(null, "Produto Alterado!");
				
				break;
			case 4:
				pesquisa = JOptionPane.showInputDialog("Digite o nome do produto que deseja alterar:");
				
				indiceProduto = nomesProdutos.indexOf(pesquisa);
				
				if (indiceProduto < 0) {
					JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado com este nome.");
					break;
				}
				
				nomesProdutos.remove(indiceProduto);
				valoresProdutos.remove(indiceProduto);
				segmentosProdutos.remove(indiceProduto);
				
				JOptionPane.showMessageDialog(null, "Produto removido!");
				
				break;
			case 5:
				int quantidadePorSegmento[] = {0, 0, 0, 0, 0};
				
				
				for (int indiceSegmento : segmentosProdutos) {
					quantidadePorSegmento[indiceSegmento]++;
				}
				
				JOptionPane.showMessageDialog(null, 
						"Total de produtos cadastrados: " + nomesProdutos.size()
						+ "\nQuantidade de produtos por segmento:"
						+ "\nÁudio e Vídeo: " + quantidadePorSegmento[0]
						+ "\nAlimentício: " + quantidadePorSegmento[1]
						+ "\nEletrodomésticos: " + quantidadePorSegmento[2]
						+ "\nInformática: " + quantidadePorSegmento[3]
						+ "\nVestuário: " + quantidadePorSegmento[4]
						);
				
				double impostosPorSegmentoMunicipal[] = {0, 0, 0, 0, 0};
				double impostosPorSegmentoEstadual[] = {0, 0, 0, 0, 0};
				double impostosPorSegmentoFederal[] = {0, 0, 0, 0, 0};
				
				for (int i = 0; i < nomesProdutos.size(); i++) {
					int indiceSegmento = segmentosProdutos.get(i);
					impostosPorSegmentoMunicipal[indiceSegmento] += valoresProdutos.get(i) * valoresSegmentosMunicipal[indiceSegmento];
					impostosPorSegmentoEstadual[indiceSegmento] += valoresProdutos.get(i) * valoresSegmentosEstadual[indiceSegmento];
					impostosPorSegmentoFederal[indiceSegmento] += valoresProdutos.get(i) * valoresSegmentosFederal[indiceSegmento];
				}
				
				JOptionPane.showMessageDialog(null, 
						"\n\nQuantidade de impostos no segmento de áudio e vídeo:\n"
						+ "\nImposto Municipal: " + impostosPorSegmentoMunicipal[0]
						+ "\nImposto Estadual: " + impostosPorSegmentoEstadual[0]
						+ "\nImposto Federal: " + impostosPorSegmentoFederal[0]
								
						+ "\n\nQuantidade de impostos no segmento alimentício:\n"
						+ "\nImposto Municipal: " + impostosPorSegmentoMunicipal[1]
						+ "\nImposto Estadual: " + impostosPorSegmentoEstadual[1]
						+ "\nImposto Federal: " + impostosPorSegmentoFederal[1]
								
						+ "\n\nQuantidade de impostos no segmento de eletrodomésticos:\n"
						+ "\nImposto Municipal: " + impostosPorSegmentoMunicipal[2]
						+ "\nImposto Estadual: " + impostosPorSegmentoEstadual[2]
						+ "\nImposto Federal: " + impostosPorSegmentoFederal[2]
								
						+ "\n\nQuantidade de impostos no segmento de informática:\n"
						+ "\nImposto Municipal: " + impostosPorSegmentoMunicipal[3]
						+ "\nImposto Estadual: " + impostosPorSegmentoEstadual[3]
						+ "\nImposto Federal: " + impostosPorSegmentoFederal[3]
								
						+ "\n\nQuantidade de impostos no segmento de vestuário:\n"
						+ "\nImposto Municipal: " + impostosPorSegmentoMunicipal[4]
						+ "\nImposto Estadual: " + impostosPorSegmentoEstadual[4]
						+ "\nImposto Federal: " + impostosPorSegmentoFederal[4]
						);
				break;
			case 6, -1:
				break infinito;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Obrigado por utilizar!");
	}
}
