package br.com.iesp.projetoweb.service;

import java.util.List;

import br.com.iesp.projetoweb.model.Cliente;
import br.com.iesp.projetoweb.repository.ClienteRepository;

public class ClienteService {

	private ClienteRepository clienteRepository = new ClienteRepository();
	
	public Cliente save(Cliente cliente) {
		if(cliente.getId() != null) {
			this.clienteRepository.update(cliente);
			return cliente;
		} else {
			return this.clienteRepository.save(cliente);
		}
	}
	
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
	
	public void remove(Long id) {
		this.clienteRepository.remove(id);
	}
	
	public Cliente getOne(Long id) {
		return this.clienteRepository.getOne(id);
	}
	
}
