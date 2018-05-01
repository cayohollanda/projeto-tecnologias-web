package br.com.iesp.projetoweb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.iesp.projetoweb.model.Contato;

public class ContatoRepository {
	
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("distribuidora");
	}
	
	private EntityManager em;
	
	public Contato save(Contato contato) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(contato);
		
		em.getTransaction().commit();
		
		em.close();
		
		return contato;
	}
	
	public List<Contato> findAll() {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Contato> contatos = em.createQuery("SELECT c FROM Contato c").getResultList();
		
		em.close();
		
		return contatos;
	}
}
