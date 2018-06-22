package com.reservations.service.interfaces;

import java.util.List;

import com.reservations.dto.FlightDto;

public interface IFlightService {

	List<FlightDto> getFlights();

}
