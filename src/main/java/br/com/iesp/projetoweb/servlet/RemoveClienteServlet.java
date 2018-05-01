package br.com.iesp.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projetoweb.service.ClienteService;

@WebServlet("/removeCliente")
public class RemoveClienteServlet extends HttpServlet {
	
	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		this.clienteService.remove(id);
		
		RequestDispatcher disp = req.getRequestDispatcher("index.jsp");
		disp.forward(req, resp);
		
	}
	
}
