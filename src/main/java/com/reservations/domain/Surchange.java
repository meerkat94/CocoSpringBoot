package com.reservations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Surchange {
	@Id
	@Column(name = "SURCHANGE_ID")
	private Integer id;

	@Column(name = "SURCHANGE_PERCENTAGE")
	private double percentage;

	public Surchange() {		
	}


}
