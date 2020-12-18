package com.fiap.chat.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
public class Login {
	@Column(name="nm_user")
	private String user;
	@Column(name="nm_password")	
	private String password;	
}
