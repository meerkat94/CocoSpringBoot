package com.reservations.builder;

import org.springframework.stereotype.Component;

import com.reservations.domain.Reserve;
import com.reservations.dto.ReserveDto;

@Component
public final class ReserveBuilder extends AbstractBuilder<Reserve, ReserveDto> {
	public ReserveBuilder() {
		super();
		this.setClassD(ReserveDto.class);
		this.setClassE(Reserve.class);
	}

}
