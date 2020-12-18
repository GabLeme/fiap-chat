package com.fiap.chat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tb_activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
