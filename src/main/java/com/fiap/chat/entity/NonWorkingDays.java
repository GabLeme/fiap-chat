package com.fiap.chat.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class NonWorkingDays {
	@Column(name="diasNaoUteis", nullable = true)
	private LocalDate diasNaoUteis;
}
