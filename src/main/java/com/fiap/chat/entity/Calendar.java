package com.fiap.chat.entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import org.hibernate.annotations.Type;

//import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name="tb_calendar", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"} ))
public class Calendar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Id
	//@SequenceGenerator(name = "calendar", sequenceName = "sq_calendar", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calendar")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cal")
	private Long id;
	
	@OneToMany//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_diasNaoUteis")
	private List<NonWorkingDays> diasNaoUteis;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calendar" )//(cascade = CascadeType.MERGE)//@JoinColumn(name = "act_id")
	private List<Activity> activity;
	

	
}
