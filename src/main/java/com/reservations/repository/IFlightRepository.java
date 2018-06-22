package com.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservations.domain.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Integer>{	

		
	
	
}
