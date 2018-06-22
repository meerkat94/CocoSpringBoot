package com.reservations.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservations.dto.ReserveDto;
import com.reservations.service.interfaces.IReserveService;

@RestController
@RequestMapping("/reserve")
public class ReserveRest {

	@Autowired
	private IReserveService reserveService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public ReserveDto add(@RequestBody ReserveDto reserveDto) {
		return reserveService.add(reserveDto);
	}

	@RequestMapping(value = "/findByUser/{id}", method = RequestMethod.GET)
	public List<ReserveDto> getReservesByUser(@PathVariable Integer id) {
		return reserveService.findReservesByUser(id);

	}

}
