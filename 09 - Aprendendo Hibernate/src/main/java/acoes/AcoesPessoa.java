package acoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;

public class AcoesPessoa {
	// Método de cadastro
	public static void cadastrar(String nome) {
		// objeto da classe Pessoa
		Pessoa p = new Pessoa();
		p.setNome (nome);
		
		// Responsável por ter aceso aos dados do arquivo de persistência
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
			
		// Responsável pelos por executar ações SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a ação SQL
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
	
	// Método de seleção
	public static void selecionar() {
		// Responsável por ter aceso aos dados do arquivo de persistência
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Responsável pelos por executar ações SQL
		EntityManager em = emf.createEntityManager();
		
		// Query para selecionar todos os dados de uma tabela
		Query query = em.createQuery("SELECT p FROM Pessoa AS p", Pessoa.class);
		
		// Armazenar o retorno em um List
		List<Pessoa> listaDePessoas = query.getResultList();
		for (Pessoa pessoa : listaDePessoas) {
			System.out.println(pessoa.getCodigo()+" - "+pessoa.getNome( ));
		}
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
	
	// Método para alterar
	public static void alterar(int codigo, String nome) {
		// Objeto da classe Pessoa
		Pessoa p = new Pessoa();
		p.setCodigo(codigo);
		p. setNome (nome);
		
		// Responsável por ter aceso aos dados do arquivo de persistência
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Responsável pelos por executar ações SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a ação SQL
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
	
	// Método para selecionar um registro específico
	public static Pessoa filtrar(int codigo) {
		// Responsável por ter aceso aos dados do arquivo de persistência
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Responsável pelos por executar ações SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a ação SQL
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, codigo);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
		
		// Retorno
		return p;
	}
	
	// Método para remover
	public static void remover(int codigo) {
		// Responsável por ter aceso aos dados do arquivo de persistência
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Responsável pelos por executar ações SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a ação SQL
		em.getTransaction().begin();
		
		// Obter a pessoa do código enviado via parâmetros
		Pessoa p = em.find(Pessoa.class, codigo);
		
		// Remover
		em.remove(p);
		
		// Executa a remoção
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
}
