package br.com.iesp.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.iesp.projetoweb.model.Usuario;
import br.com.iesp.projetoweb.service.UsuarioService;

@WebServlet("/cadastrar")
public class CadastraServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Pegando usuário e senha a serem cadastrados
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		// Criando o usuário e já setando os valores do mesmo.
		// Quando vou setar a senha, seto ela já criptografada, com o uso do
		// BCryptPasswordEncoder, puxando o método encode() dessa classe e
		// passando a String da senha como parâmetro
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setSenha(new BCryptPasswordEncoder().encode(senha));
		
		// Salvando o usuário no banco de dados
		this.usuarioService.save(user);
		
		// Fazendo o RequestDispatcher para enviar para a página de login
		// e enviando um parâmetro "cadastrado" para na tela de login
		// mostrar uma mensagem de "Cadastrado com sucesso!"
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		req.setAttribute("cadastrado", 1);
		rd.forward(req, resp);

	}
	
}
