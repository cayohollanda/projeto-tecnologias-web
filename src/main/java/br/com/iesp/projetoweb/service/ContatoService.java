package br.com.iesp.projetoweb.service;

import java.util.List;

import br.com.iesp.projetoweb.model.Contato;
import br.com.iesp.projetoweb.repository.ContatoRepository;

public class ContatoService {
	
	private ContatoRepository contatoRepository = new ContatoRepository();
	
	public Contato save(Contato contato) {
		return this.contatoRepository.save(contato);
	}
	
	public List<Contato> findAll() {
		return this.contatoRepository.findAll();
	}

}
