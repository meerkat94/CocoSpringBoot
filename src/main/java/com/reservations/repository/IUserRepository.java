package com.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservations.domain.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	
}
