package com.reservations.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateTimeUtilTests {

	private static final int ADDITIONAL_DAYS_FROM_THE_CURRENT = 5;
	@Test
	public void isWeekendWhenIsThursday() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(2018, Calendar.JUNE, 14);
		assertFalse(DateTimeUtil.isWeekend(currentDate));
	}
	
	@Test
	public void isWeekendWhenIsSaturday() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(2018, Calendar.JUNE, 16);
		assertTrue(DateTimeUtil.isWeekend(currentDate));
	}
	@Test
	public void isWeekendWhenIsSunday() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(2018, Calendar.JUNE, 17);
		assertTrue(DateTimeUtil.isWeekend(currentDate));
	}
	@Test
	public void isMorningScheduleWhenIsAm() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 10);
		assertTrue(DateTimeUtil.isMorningSchedule(currentDate));
	}
	@Test
	public void isMorningScheduleWhenIsPm() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 13);
		assertFalse(DateTimeUtil.isMorningSchedule(currentDate));
	}
	@Test
	public void isMorningScheduleWhenIsMidday() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 12);
		assertFalse(DateTimeUtil.isMorningSchedule(currentDate));
	}
	@Test
	public void isMorningScheduleWhenIsMidnigth() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		assertFalse(DateTimeUtil.isMorningSchedule(currentDate));
	}
	@Test
	public void isTheCurrentDayWhenisTrue() {
		Calendar date = Calendar.getInstance();
		assertTrue(DateTimeUtil.isTheCurrentDay(date));
	}
	@Test
	public void isTheCurrentDayWhenisFalse() {
		Calendar date = Calendar.getInstance();
		date.set(2018, Calendar.DECEMBER, Calendar.getInstance().get((Calendar.DATE))+ADDITIONAL_DAYS_FROM_THE_CURRENT);
		assertFalse(DateTimeUtil.isTheCurrentDay(date));
	}

}
