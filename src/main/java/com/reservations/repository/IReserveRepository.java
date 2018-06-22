package com.reservations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservations.domain.Reserve;
import com.reservations.domain.User;

public interface IReserveRepository extends JpaRepository<Reserve, Integer> {

	List<Reserve> findReservesByUser(User user);

}
