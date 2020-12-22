package com.fiap.chat.entity;


import javax.persistence.Column;



/**
 * TODO: Criar DTO para conversao 
 */

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_user")
	private Long id;
	
	@Embedded
	@Valid
	private Login login;
	
	@CPF
	@NotBlank(message = "Cpf nao pode ser vazio")
	@NotNull(message = "Cpf nao pode ser nulo")
	private String cpf;
}
