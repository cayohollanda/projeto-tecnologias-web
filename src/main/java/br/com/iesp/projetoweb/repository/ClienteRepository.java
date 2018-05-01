package br.com.iesp.projetoweb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.iesp.projetoweb.model.Cliente;

public class ClienteRepository {
	
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("distribuidora");
	}
	
	private EntityManager em;
	
	public Cliente save(Cliente cliente) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		
		em.close();
		
		return cliente;
	}
	
	public List<Cliente> findAll() {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
		
		em.close();
		
		return clientes;
	}
	
	public void remove(Long id) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Cliente cliente = em.find(Cliente.class, id);
		
		em.remove(cliente);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void update(Cliente cliente) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(cliente);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public Cliente getOne(Long id) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Cliente cliente = em.find(Cliente.class, id);
		
		em.close();
		
		return cliente;
	}
	
}
