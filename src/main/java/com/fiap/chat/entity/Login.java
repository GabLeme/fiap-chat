package com.fiap.chat.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Embeddable
public class Login {
	
	@NotNull(message = "Email nao pode ser nulo")
	@NotBlank(message = "Email nao pode ser vazio")
	@Email
	@Column(name="nm_email", nullable = false)
	private String email;
	
	@NotNull(message = "Senha nao pode ser nula")
	@NotBlank(message = "Senha nao pode ser vazia")
	@Size(min = 8, message = "A senha precisa conter no minimo 8 caracteres")
	@Column(name="nm_password", nullable = false)	
	private String password;	
}
