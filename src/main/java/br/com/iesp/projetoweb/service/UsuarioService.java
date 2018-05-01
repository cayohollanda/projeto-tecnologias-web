package br.com.iesp.projetoweb.service;

import br.com.iesp.projetoweb.model.Usuario;
import br.com.iesp.projetoweb.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		this.usuarioRepository = new UsuarioRepository();
	}
	
	public boolean login(Usuario usuario) {
		return this.usuarioRepository.validaUsuario(usuario);
	}
	
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
}
