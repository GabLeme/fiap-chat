package com.fiap.chat.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
@Table(name="tb_activity")
public class Activity {
	
	@Id
	//@SequenceGenerator(name = "activity", sequenceName = "sq_activity", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="activity")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="act_id")
	private Long id;
	
	@Column(name="act_titulo")
	private String titulo;
	
	@Column(name="act_descricao")
	private String descricao;
	
	@Column(name="act_dt_inicio")
	private LocalDateTime dt_inicio;
	
	@Column(name="act_dt_fim")
	private LocalDateTime dt_fim;
	
	@ManyToOne(fetch = FetchType.LAZY)//()
	@JsonProperty(access = Access.WRITE_ONLY)
	//@JoinColumn(name="cal_id")
	private Calendar calendar;
	
}
