package com.reservations;

import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.reservations.domain.Flight;
import com.reservations.repository.IFlightRepository;

@SpringBootApplication
@ComponentScan({ "com.reservations.rest", "com.reservations.service.*", "com.reservations.validation",
		"com.reservations.builder" })
@EnableJpaRepositories("com.reservations.repository")
@EntityScan("com.reservations.domain")
@EnableWebMvc

public class ReservationsApplication {

	@Autowired
	IFlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReservationsApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	public CommandLineRunner setupp(IFlightRepository flightRepository) {
		return (args) -> {
			flightRepository.save(new Flight(1, Calendar.getInstance(), "Bogota", "Madrid",3000));
			flightRepository.save(new Flight(2, Calendar.getInstance(), "Rionegro", "Bogota",4000));
			flightRepository.save(new Flight(3, Calendar.getInstance(), "Cali", "Barranquilla",2500));
			flightRepository.save(new Flight(4, Calendar.getInstance(), "Bogota", "Mexico",5000));

		};
	}

}
