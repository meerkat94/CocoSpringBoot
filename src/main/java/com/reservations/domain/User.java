package com.reservations.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@Column(name = "USER_ID")
	private Integer id;

	@Column(name = "USER_AGE")
	private Integer age;

	@OneToMany(mappedBy = "user")
	private List<Reserve> reserves;

	public User(Integer id, Integer age) {
		super();
		this.id = id;
		this.age = age;
	}
	
	public User() {
		  // Do nothing.
		}

	public Integer getId() {
		return id;
	}

	public Integer getAge() {
		return age;
	}


}
