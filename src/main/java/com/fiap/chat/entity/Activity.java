package com.fiap.chat.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tb_activity")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="act_ID")
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="datetime")
	private LocalDateTime datetime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cal_ID")
	private Calendar calendar;
	
}
