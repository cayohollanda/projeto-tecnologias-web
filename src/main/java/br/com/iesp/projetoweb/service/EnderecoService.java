package br.com.iesp.projetoweb.service;

import br.com.iesp.projetoweb.model.Endereco;
import br.com.iesp.projetoweb.repository.EnderecoRepository;

public class EnderecoService {

	private EnderecoRepository enderecoRepository = new EnderecoRepository();
	
	public Endereco save(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}
	
}
