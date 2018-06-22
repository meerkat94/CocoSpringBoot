package com.reservations.util;

import com.reservations.constants.PersonalDataConstants;
import com.reservations.domain.User;

public class PersonalDataUtil {

	private PersonalDataUtil() {
	}

	public static boolean isAdult(User user) {
		return (user.getAge() >= PersonalDataConstants.ADULT_AGE_START);

	}

}
