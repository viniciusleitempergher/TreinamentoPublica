package exercicio03;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class App {
	private int indiceUsuario;
	private Usuario usuario;
	
	public App(int indiceUsuario) {
		this.indiceUsuario = indiceUsuario;
	}
	
	public void iniciar() {
		usuario = Autenticacao.usuarios.get(indiceUsuario);
		
		String[] opcoes = {
				"Sacar",
                "Depositar",
                "Extrato",
                "Logout"
                };
		
		infinito: while (true) {
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema Bancário",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			switch (opcao) {
			case 0:
				double valor = Double.parseDouble(
							JOptionPane.showInputDialog("Digite valor:")
						);
				double saldo = usuario.getConta().getSaldo();
				
				if (valor > saldo) {
					JOptionPane.showMessageDialog(null, "Você não tem saldo para essa quantia!");
					break;
				}
				if (valor < 0) {
					JOptionPane.showMessageDialog(null, "Impossível sacar negativo!");
					break;
				}
				
				usuario.getConta().setSaldo(saldo - valor);
				
				Movimentacao saque = new Movimentacao(-valor);
				
				usuario.getConta().movimentacoes.add(saque);
				
				JOptionPane.showMessageDialog(null, "Valor sacado!");
				
				break;
			case 1:
				valor = Double.parseDouble(
						JOptionPane.showInputDialog("Digite valor:")
					);
				saldo = usuario.getConta().getSaldo();
			
				if (valor < 0) {
					JOptionPane.showMessageDialog(null, "Impossível depositar negativo!");
					break;
				}
				
				usuario.getConta().setSaldo(saldo + valor);
				
				Movimentacao deposito = new Movimentacao(valor);
				
				usuario.getConta().movimentacoes.add(deposito);
				
				JOptionPane.showMessageDialog(null, "Valor depositado!");
				break;
			case 2:
				String extrato = "";
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				for (Movimentacao m : usuario.getConta().movimentacoes) {
					extrato += "\n" + (m.getValor() > 0 ? "Depósito" : "Saque") + "\n";
					extrato += "Valor: " + (m.getValor() > 0 ? m.getValor() : m.getValor() * -1) + "\n";
					extrato += "Data: " + df.format(m.getData()) + "\n\n";
				}
				extrato += "Saldo: " + usuario.getConta().getSaldo();
				
				JOptionPane.showMessageDialog(null, extrato);
				break;
			case 3:
				Autenticacao.logout();
				break infinito;
			}
		}
		
		Autenticacao.usuarios.set(indiceUsuario, usuario);
	}
}
