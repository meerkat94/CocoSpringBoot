package com.reservations.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservations.dto.FlightDto;
import com.reservations.service.implementation.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
public class FlightRest {

	@Autowired
	private FlightServiceImpl flightService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<FlightDto> getFlights() {
		return flightService.getFlights();

	}

}
