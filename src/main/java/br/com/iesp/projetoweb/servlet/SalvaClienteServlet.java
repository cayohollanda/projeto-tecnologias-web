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
import br.com.iesp.projetoweb.model.Endereco;
import br.com.iesp.projetoweb.service.ClienteService;
import br.com.iesp.projetoweb.service.ContatoService;
import br.com.iesp.projetoweb.service.EnderecoService;

@WebServlet("/salvaCliente")
public class SalvaClienteServlet extends HttpServlet {

	private ClienteService clienteService;
	private ContatoService contatoService;
	private EnderecoService enderecoService;
	
	@Override
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
		this.contatoService = new ContatoService();
		this.enderecoService = new EnderecoService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String idContato = req.getParameter("idContato");
		String idEndereco = req.getParameter("idEndereco");
		System.out.println(id);
		System.out.println(idContato);
		System.out.println(idEndereco);
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String rua = req.getParameter("rua");
		String bairro = req.getParameter("bairro");
		String estado = req.getParameter("estado");
		String cidade = req.getParameter("cidade");
		String numero = req.getParameter("numero");
		String obs = req.getParameter("obs");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		cliente.setEndereco(endereco);
		cliente.setContato(contato);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.getEndereco().setRua(rua);
		cliente.getEndereco().setBairro(bairro);
		cliente.getEndereco().setEstado(estado);
		cliente.getEndereco().setCidade(cidade);
		cliente.getEndereco().setNumero(numero);
		cliente.getEndereco().setObs(obs);
		cliente.getContato().setEmail(email);
		cliente.getContato().setTelefone(telefone);

		if(!id.equals("")) {
			cliente.setId(Long.parseLong(id));
			cliente.getEndereco().setId(Long.parseLong(idEndereco));
			cliente.getContato().setId(Long.parseLong(idContato));
		}
		
		this.clienteService.save(cliente);
		
		RequestDispatcher disp = req.getRequestDispatcher("clientes.jsp");
		List<Cliente> clientes = this.clienteService.findAll();
		req.setAttribute("clientes", clientes);
		req.setAttribute("mensagem", "Cliente salvo com sucesso!");
		disp.forward(req, resp);
	}
	
}
