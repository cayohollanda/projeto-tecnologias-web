package br.com.iesp.projetoweb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.iesp.projetoweb.model.Usuario;

public class UsuarioRepository {

	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("distribuidora");
	}
	
	private EntityManager em;
	
	public Usuario save(Usuario usuario) {
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		
		return usuario;
	}
	
	// Método que informa se o usuário passado está correto
	public boolean validaUsuario(Usuario usuario) {
		// Determinando uma variável para a resposta
		boolean resposta = false;
		
		this.em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		// Criando a Query personalizada (não precisa colocar o SELECT)
		Query valida = em.createQuery("FROM Usuario u WHERE usuario = ?1");
		
		// Setando o parâmetro que foi referenciado na Query (usuario = ?1)
		valida.setParameter(1, usuario.getUsuario());
		// Setando que o máximo de resultados será um
		valida.setMaxResults(1);
		
		// Recuperando o resultado da query em uma lista de usuários
		List<Usuario> logado = valida.getResultList();
		
		em.getTransaction().commit();
		
		// Verificando se obteve algum resultado, pois se não teve
		// resultado algum, significa que não existe esse usuário
		// no banco, logo, retorno falso
		if(logado.size() < 1) {
			return resposta;
		}
		
		// Pegando o primeiro (e único) usuário da lista
		Usuario verify = logado.get(0);
		
		// Criando um objeto do tipo BCryptPasswordEncoder para
		// fazer a comparação entre a senha recebida no formulário
		// com a senha que está criptografada no banco
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// Comparando a senha que veio do formulário com a senha
		// que está criptografada no banco, se baterem, seta o
		// valor da resposta para true
		if(encoder.matches(usuario.getSenha(), verify.getSenha())) {
			resposta = true;
		}
		
		// Fechando a conexão
		em.close();
		
		// Retornando a resposta
		return resposta;
		
	}
	
}
