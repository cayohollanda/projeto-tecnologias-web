package br.com.iesp.projetoweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@CPF
	private String cpf;
	
	@JoinColumn(name = "endereco_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JoinColumn(name = "contato_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Contato contato;
	
}
