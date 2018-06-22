package com.reservations.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservations.builder.FlightBuilder;
import com.reservations.domain.Flight;
import com.reservations.dto.FlightDto;
import com.reservations.repository.IFlightRepository;
import com.reservations.service.interfaces.IFlightService;

@Service
public class FlightServiceImpl implements IFlightService {

	@Autowired
	IFlightRepository flightRepository;
	@Autowired
	FlightBuilder flightBuilder;

	@Override
	@Transactional
	public List<FlightDto> getFlights() {
		List<Flight> flightsList = flightRepository.findAll();
		List<FlightDto> flightsListDto = new ArrayList<>();
		flightsList.forEach(flight -> flightsListDto.add(flightBuilder.entityToDTO(flight)));
		return flightsListDto;

	}

}
