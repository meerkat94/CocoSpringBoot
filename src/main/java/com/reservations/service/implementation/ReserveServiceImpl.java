package com.reservations.service.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservations.builder.ReserveBuilder;
import com.reservations.constants.LogicalExceptionConstants;
import com.reservations.domain.Flight;
import com.reservations.domain.Reserve;
import com.reservations.domain.User;
import com.reservations.dto.ReserveDto;
import com.reservations.exceptions.LogicalException;
import com.reservations.repository.IFlightRepository;
import com.reservations.repository.IReserveRepository;
import com.reservations.repository.IUserRepository;
import com.reservations.service.interfaces.IReserveService;
import com.reservations.util.PersonalDataUtil;

@Service
public class ReserveServiceImpl implements IReserveService {

	@Autowired
	IReserveRepository reserveRepository;
	@Autowired
	IFlightRepository flightRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	ReserveBuilder reserveBuilder;

	@Override
	@Transactional
	public ReserveDto add(ReserveDto reserveDto) {

		Reserve reserve = new Reserve();
		Optional<Flight> flightOptional = flightRepository.findById(reserveDto.getFlightId());
		Optional<User> userOptional = userRepository.findById(reserveDto.getUserId());
		validateUser(reserve, userOptional);
		validateFlight(reserve, flightOptional);
		reserve.setDateTime(Calendar.getInstance());
		if (isNotAdult(reserve)) {
			throw new LogicalException(LogicalExceptionConstants.THE_USER_ISNOT_ADULT);
		}
		reserveRepository.save(reserve);
		return reserveBuilder.entityToDTO(reserve);
	}

	private boolean isNotAdult(Reserve reserve) {
		return !PersonalDataUtil.isAdult(reserve.getUser());
	}

	private void validateFlight(Reserve reserve, Optional<Flight> flightOptional) {
		if (flightOptional.isPresent()) {
			throw new LogicalException(LogicalExceptionConstants.THE_FLIGHT_COULDNOT_FOUND);
		}
		Flight flight = flightOptional.get();
		reserve.setFlight(flight);
	}

	private void validateUser(Reserve reserve, Optional<User> userOptional) {
		if (!userOptional.isPresent()) {
			throw new LogicalException(LogicalExceptionConstants.THE_USER_COULDNOT_FOUND);
		}
		User user = userOptional.get();
		reserve.setUser(user);

	}

	@Override
	public List<ReserveDto> findReservesByUser(Integer userId) {
		List<ReserveDto> reserveListDto = new ArrayList<>();
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			List<Reserve> reserveList = reserveRepository.findReservesByUser(user);
			reserveList.forEach(reserve -> reserveListDto.add(reserveBuilder.entityToDTO(reserve)));
		}
		return reserveListDto;
	}

}
