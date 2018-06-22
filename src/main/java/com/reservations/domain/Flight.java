package com.reservations.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@Column(name = "FLIGHT_ID")
	private Integer id;

	@Column(name = "FLIGHT_DATETIME")
	private Calendar dateTime;

	@Column(name = "FLIGHT_ORIGIN")
	private String origin;

	@Column(name = "FLIGHT_DESTINATION")
	private String destination;

	@Column(name = "FLIGHT_COST")
	private double cost;

	public Flight(Integer id, Calendar dateTime, String origin, String destination, double cost) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
	}

	public Flight() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
