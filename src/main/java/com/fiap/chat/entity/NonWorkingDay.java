package com.fiap.chat.entity;

import java.time.LocalDate;

import javax.persistence.Column;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
@Table(name="tb_diaNaoUtil", uniqueConstraints = @UniqueConstraint(columnNames = {"diaNaoUtil"} ))
public class NonWorkingDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_diaNaoUtil")
	private Long id;
	
	
	@Column(name="diaNaoUtil", nullable = true)
	private LocalDate diaNaoUtil;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Calendar calendar;
}
