package com.fiap.chat.entity;

//import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
//import javax.persistence.Column;
//import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.Valid;

//import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
@Table(name="tb_calendar")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cal_ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)//, mappedBy = "calendar")//, orphanRemoval=true)
	@JoinColumn(name = "act_ID")
	private List<Activity> activity;
	
	/*
	@Embedded
	@Valid
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<Activity> activities;
	//private List<LocalDate> dates;
	@Embedded
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private List<Activity> activity;
	//private List<LocalDate> diasNaoUteis;
	 */
}
