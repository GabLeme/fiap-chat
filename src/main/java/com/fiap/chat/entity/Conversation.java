package com.fiap.chat.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_conversation")
public class Conversation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "conversation_id")
	private Long id;	
	
	private String title;
}	
