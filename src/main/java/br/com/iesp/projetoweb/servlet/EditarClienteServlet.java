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
import br.com.iesp.projetoweb.service.ClienteService;

@WebServlet("/editaCliente")
public class EditarClienteServlet extends HttpServlet {

	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		Cliente cliente = this.clienteService.getOne(id);
		
		RequestDispatcher disp = req.getRequestDispatcher("clientes.jsp");
		
		List<Cliente> clientes = this.clienteService.findAll();
		
		req.setAttribute("cliente", cliente);
		req.setAttribute("clientes", clientes);
		
		disp.forward(req, resp);
		
	}
	
}
