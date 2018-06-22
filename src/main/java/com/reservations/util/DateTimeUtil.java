package com.reservations.util;

import java.util.Calendar;

import com.reservations.constants.DateTimeConstants;

public class DateTimeUtil {

	private DateTimeUtil() {
	}

	public static boolean isWeekend(Calendar currentDate) {
		return (currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);

	}

	public static boolean isMorningSchedule(Calendar currentDate) {
		return (currentDate.get(Calendar.HOUR_OF_DAY) < DateTimeConstants.MIDDAY_HOUR_START
				&& currentDate.get(Calendar.HOUR_OF_DAY) > DateTimeConstants.MIDNIGHT_HOUR_START);

	}

	public static boolean isTheCurrentDay(Calendar date) {
		Calendar currentDate = Calendar.getInstance();
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		int day = date.get(Calendar.DATE);
		return (month == currentDate.get(Calendar.MONTH) && year == currentDate.get(Calendar.YEAR)
				&& day == currentDate.get(Calendar.DATE));

	}

}
