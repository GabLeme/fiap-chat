package com.fiap.chat.entity;


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
//import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import org.hibernate.annotations.Type;

//import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name="tb_calendar")
public class Calendar{
	
	@Id
	@SequenceGenerator(name = "calendar", sequenceName = "sq_calendar", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calendar")
	@Column(name="id_cal")
	private Long id;
	
	//@Column(name="cal_nome")
	//private String descricao;
	
	//@OneToMany//(cascade = CascadeType.ALL)
	//@JoinTable(joinColumns=@JoinColumn(name="id_cal"), name="tb_diasNaoUteis") //LocalDate
	//@Type(type="JSON")
	//@OneToMany(cascade = CascadeType.ALL)
	//@JsonProperty(access = Access.WRITE_ONLY)
	//@Column(name="diasNaoUteis")//, columnDefinition = "JSON")
	//private LocalDate diasNaoUteis; //List<LocalDate>
	@Embedded
	@Column(name="cal_diasNaoUteis")
	private List<String> diasNaoUteis;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "act_id")
	private List<Activity> activity;
	

	
}
