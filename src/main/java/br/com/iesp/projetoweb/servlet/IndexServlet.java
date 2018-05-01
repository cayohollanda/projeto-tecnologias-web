package br.com.iesp.projetoweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projetoweb.model.Cliente;
import br.com.iesp.projetoweb.model.Contato;
import br.com.iesp.projetoweb.service.ClienteService;
import br.com.iesp.projetoweb.service.ContatoService;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Cliente> clientes = this.clienteService.findAll();
		
		req.setAttribute("clientes", clientes);
		
		RequestDispatcher disp = req.getRequestDispatcher("clientes.jsp");
		disp.forward(req, resp);
		
	}
	
}
