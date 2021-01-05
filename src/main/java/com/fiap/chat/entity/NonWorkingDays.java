package com.fiap.chat.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tb_diasNaoUteis")
public class NonWorkingDays {
	
	@Id
	//@SequenceGenerator(name = "diasNaoUteis", sequenceName = "sq_diasNaoUteis", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="diasNaoUteis")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_diasNaoUteis")
	private Long id;
	
	
	@Column(name="diasNaoUteis", nullable = true)
	private LocalDate diasNaoUteis;
	
	@ManyToOne
	@JoinColumn(name="id_cal")
	private Calendar calendar;
}
