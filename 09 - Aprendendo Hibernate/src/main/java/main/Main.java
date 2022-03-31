package main;

import acoes.AcoesPessoa;
import entidade.Pessoa;

public class Main {
	public static void main(String[] args) {
		AcoesPessoa.cadastrar("Vinícius");
		AcoesPessoa.alterar(1, "Jailson");
		//AcoesPessoa.remover(3);
		AcoesPessoa.selecionar();
		
		Pessoa p = AcoesPessoa.filtrar(1);
		System.out.println(p.getNome());	
	}
}
