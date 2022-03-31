package acoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;

public class AcoesPessoa {
	// M�todo de cadastro
	public static void cadastrar(String nome) {
		// objeto da classe Pessoa
		Pessoa p = new Pessoa();
		p.setNome (nome);
		
		// Respons�vel por ter aceso aos dados do arquivo de persist�ncia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
			
		// Respons�vel pelos por executar a��es SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a a��o SQL
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
	
	// M�todo de sele��o
	public static void selecionar() {
		// Respons�vel por ter aceso aos dados do arquivo de persist�ncia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Respons�vel pelos por executar a��es SQL
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
	
	// M�todo para alterar
	public static void alterar(int codigo, String nome) {
		// Objeto da classe Pessoa
		Pessoa p = new Pessoa();
		p.setCodigo(codigo);
		p. setNome (nome);
		
		// Respons�vel por ter aceso aos dados do arquivo de persist�ncia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Respons�vel pelos por executar a��es SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a a��o SQL
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
	
	// M�todo para selecionar um registro espec�fico
	public static Pessoa filtrar(int codigo) {
		// Respons�vel por ter aceso aos dados do arquivo de persist�ncia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Respons�vel pelos por executar a��es SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a a��o SQL
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, codigo);
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
		
		// Retorno
		return p;
	}
	
	// M�todo para remover
	public static void remover(int codigo) {
		// Respons�vel por ter aceso aos dados do arquivo de persist�ncia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		
		// Respons�vel pelos por executar a��es SQL
		EntityManager em = emf.createEntityManager();
		
		// Prepara a a��o SQL
		em.getTransaction().begin();
		
		// Obter a pessoa do c�digo enviado via par�metros
		Pessoa p = em.find(Pessoa.class, codigo);
		
		// Remover
		em.remove(p);
		
		// Executa a remo��o
		em.getTransaction().commit();
		
		// Finalizar o EntityManagerFactory e o EntityManager
		emf.close();
		em.close();
	}
}
