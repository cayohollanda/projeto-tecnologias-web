package br.com.iesp.projetoweb.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.iesp.projetoweb.model.Endereco;

public class EnderecoRepository {

	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("distribuidora");
	}
	
	private EntityManager em;
	
	public Endereco save(Endereco endereco) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(endereco);
		
		em.getTransaction().commit();
		
		em.close();
		
		return endereco;
	}
	
}
