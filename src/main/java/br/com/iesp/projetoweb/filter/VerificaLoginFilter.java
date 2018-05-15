package br.com.iesp.projetoweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class VerificaLoginFilter
 */

@WebFilter(filterName="/VerificaLoginFilter", urlPatterns={"/clientes.jsp", "/index"})
public class VerificaLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VerificaLoginFilter() { }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Fazendo cast do objeto do tipo ServletRequest para HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		
		// Recuperando sessão do request
		HttpSession session = req.getSession();
		
		// Recuperando usuário da sessão
		String user = "";
		
		// Fazendo um try-catch para recuperar o usuario da sessão, caso não haja, continuará com o valor vazio
		try {
			user = session.getAttribute("usuario").toString();
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		// Verificando se o usuário está vazio, se estiver, envia para o login, senão, passa para frente
		if(user.isEmpty()) {
			System.out.println("Sem sessão ativa no momento.");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException { }

}
