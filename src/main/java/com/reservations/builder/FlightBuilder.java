package com.reservations.builder;

import org.springframework.stereotype.Component;

import com.reservations.domain.Flight;
import com.reservations.dto.FlightDto;

@Component
public final class FlightBuilder extends AbstractBuilder<Flight, FlightDto> {
	public FlightBuilder() {
		super();
		this.setClassD(FlightDto.class);
		this.setClassE(Flight.class);
	}

}
