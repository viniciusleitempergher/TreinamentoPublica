package exercicio05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Leitor {
	private static String usersPath = "C:\\Users\\Publica\\Desktop\\TreinamentoPublica\\04 - Exercícios POO\\src\\exercicio05\\dados\\users.txt";
	private static String productsPath = "C:\\Users\\Publica\\Desktop\\TreinamentoPublica\\04 - Exercícios POO\\src\\exercicio05\\dados\\products.txt";
	
	public static Usuario procurarUsuario(String login, String senha) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(usersPath));
		String linha = "";
		while (true) {
			if (linha == null) break;

			String[] informacoesU = linha.split(";");
			
			if (informacoesU[0].equals(login)) {
				if (informacoesU[1].equals(senha)) {
					buffRead.close();
					return informacoesU[2].equals("1")
							? new Usuario(login, senha, true) 
							: new Usuario(login, senha, false);
				}
			}
			
			linha = buffRead.readLine();
		}
		buffRead.close();
		
		return null;
	}
	
	public static ArrayList<Usuario> listarUsuarios() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(usersPath));
		String linha = "";
		ArrayList<Usuario> usuarios = new ArrayList<>();
		while (true) {
			linha = buffRead.readLine();
			
			if (linha == null) break;
			
			String[] informacoesU = linha.split(";");
			usuarios.add(new Usuario(informacoesU[0], informacoesU[1],
					informacoesU[2].equals("1")));
		}
		buffRead.close();
		
		return usuarios;
	}
	
	public static void gravarUsuario(Usuario u) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(usersPath, true));
		buffWrite.newLine();
		buffWrite.append(u.getLogin() + ";" + u.getSenha() + ";" 
				+ (u.isAdmin() ? "1" : "0"));
		buffWrite.close();
	}
	
	public static void deletarUsuario(String login) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(usersPath));
		String line = "";
		String arquivo = "";
		boolean primeiro = true;
		while (true) {
			line = buffRead.readLine();
			if (line == null) break;

			String[] informacoesU = line.split(";");
			
			if (!informacoesU[0].equals(login)) {
				if (!primeiro) {
					arquivo += "\n";
				}
				primeiro = false;
				arquivo += informacoesU[0] + ";" + informacoesU[1] + ";" + informacoesU[2];
			}
		}
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(usersPath, false));
		
		buffWrite.write(arquivo);
		
		buffWrite.close();
		buffRead.close();
	}
	
	public static ArrayList<Produto> listarProdutos() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(productsPath));
		String linha = "";
		ArrayList<Produto> produtos = new ArrayList<>();
		while (true) {
			linha = buffRead.readLine();
			
			if (linha == null) break;
			
			String[] informacoesP = linha.split(";");
			produtos.add(new Produto(informacoesP[0], informacoesP[1],
					Double.parseDouble(informacoesP[2])));
		}
		buffRead.close();
		
		return produtos;
	}
	
	public static void gravarProduto(Produto p) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(productsPath, true));
		buffWrite.newLine();
		buffWrite.append(p.getNome() + ";" + p.getMarca() + ";" + p.getValor());
		buffWrite.close();
	}
	
	public static void deletarProduto(String nome) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(productsPath));
		String line = "";
		String arquivo = "";
		boolean primeiro = true;
		while (true) {
			line = buffRead.readLine();
			if (line == null) break;

			String[] informacoesP = line.split(";");
			
			if (!informacoesP[0].equals(nome)) {
				if (!primeiro) {
					arquivo += "\n";
				}
				primeiro = false;
				arquivo += informacoesP[0] + ";" + informacoesP[1] + ";" + informacoesP[2];
			}
		}
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(productsPath, false));
		
		buffWrite.write(arquivo);
		
		buffWrite.close();
		buffRead.close();
	}
	
	public static void editarProduto(String nome, Produto novoProduto) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(productsPath));
		String line = "";
		String arquivo = "";
		boolean primeiro = true;
		while (true) {
			line = buffRead.readLine();
			if (line == null) break;

			String[] informacoesP = line.split(";");
			
			if (informacoesP[0].equals(nome)) {
				if (!primeiro) {
					arquivo += "\n";
				}
				primeiro = false;
				arquivo += novoProduto.getNome() + ";" + novoProduto.getMarca() + ";" + novoProduto.getValor();
			} else {
				if (!primeiro) {
					arquivo += "\n";
				}
				primeiro = false;
				arquivo += informacoesP[0] + ";" + informacoesP[1] + ";" + informacoesP[2];
			}
		}
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(productsPath, false));
		
		buffWrite.write(arquivo);
		
		buffWrite.close();
		buffRead.close();
	}
}
