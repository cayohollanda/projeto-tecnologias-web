package br.com.iesp.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mysql.fabric.xmlrpc.base.ResponseParser;

import br.com.iesp.projetoweb.model.Usuario;
import br.com.iesp.projetoweb.service.UsuarioService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Recuperando os dados do formulário
		String usuarioForm = req.getParameter("usuario");
		// Pegando a senha e já criptografando ela com o BCryptPasswordEncoder
		String senhaForm = req.getParameter("senha");
		
		// Criando o usuário com os dados recuperados pelo formulário
		Usuario usuario = new Usuario();
		usuario.setUsuario(usuarioForm);
		usuario.setSenha(senhaForm);
		
		// Verificando se os dados estão batendo com o que tem no banco
		if(this.usuarioService.login(usuario)) {
			// Recuperando sessão, adicionando usuário como atributo da sessão
			// e adicionando o tempo máximo de inatividade
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario.getUsuario());
			session.setMaxInactiveInterval(30 * 60);
			
			// Criando cookie com o usuário como valor e adicionando ao response
			Cookie cookie = new Cookie("usuario", usuario.getUsuario());
			resp.addCookie(cookie);
			
			// Criando o RequestDispatcher para redirecionar para a tela de login
			// e adicinando a flag "logado", tempo de sessão e última vez acessado
			RequestDispatcher rd = req.getRequestDispatcher("clientes.jsp");
			rd.forward(req, resp);
		} else {
			// Caso os dados não batam, apenas retorna para a tela de login
			// com o parametro "error" que é verificado na tela de login
			// para mostrar a mensagem de erro.
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("error", 1);
			rd.forward(req, resp);
		}
		
	}
	
}
