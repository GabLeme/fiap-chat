package com.fiap.chat.entity;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "act_ID")
	private List<Activity> activity;
	
}
