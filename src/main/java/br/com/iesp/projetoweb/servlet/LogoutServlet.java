package br.com.iesp.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sair")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Recupero a sessão
		HttpSession session = req.getSession();
		// Removo o atributo de usuário da sessão
		session.removeAttribute("usuario");
		
		// Envio o usuário para a tela de login, com o parâmetro logout para
		// na tela de login, aparecer uma mensagem de "Volte sempre!"
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		req.setAttribute("logout", 1);
		
		rd.forward(req, resp);
	
	}
	
}
