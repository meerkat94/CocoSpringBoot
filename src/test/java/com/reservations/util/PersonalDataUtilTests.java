package com.reservations.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.reservations.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalDataUtilTests {

	
	@Test
	public void isAdultWhenIsFalse() {
		User user = new User(1,12);
		assertFalse(PersonalDataUtil.isAdult(user));
	}
	
	@Test
	public void isAdultWhenIsTrue() {
		User user = new User(1,19);
		assertTrue(PersonalDataUtil.isAdult(user));
	}
	
}
