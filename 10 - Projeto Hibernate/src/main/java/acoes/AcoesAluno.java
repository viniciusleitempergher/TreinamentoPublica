package acoes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Aluno;

public class AcoesAluno {
	public static void cadastrar(Aluno a) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-hibernate");
			
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}
	
	public static List<Aluno> selectAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT a FROM Aluno AS a", Aluno.class);
		
		List<Aluno> alunos = query.getResultList();
		
		emf.close();
		em.close();
		
		return alunos;
	}
	
	public static void alterar(Aluno a) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}
	
	public static void remover(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Aluno a = em.find(Aluno.class, id);
		
		em.remove(a);
		
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}
	
	public static Aluno findById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Aluno a = em.find(Aluno.class, id);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
		return a;
	}
}
