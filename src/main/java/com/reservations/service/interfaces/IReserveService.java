package com.reservations.service.interfaces;

import java.util.List;

import com.reservations.dto.ReserveDto;

public interface IReserveService {

	ReserveDto add(ReserveDto articuloDto);

	List<ReserveDto> findReservesByUser(Integer id);

}
