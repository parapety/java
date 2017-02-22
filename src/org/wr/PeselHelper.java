package org.wr;

import java.util.Calendar;
import java.util.Date;

public class PeselHelper {
	public static Date extractDate(String pesel) {
		Integer year = Integer.parseInt(pesel.substring(0, 2));
		Integer month = Integer.parseInt(pesel.substring(2, 4));
		Integer day = Integer.parseInt(pesel.substring(4, 6));
		int monthFactor = month / 10;
		if (monthFactor <= 1) {
			year += 1900;
		} else if (monthFactor <= 3) {
			year += 2000;
			month -= 20;
		} else if (monthFactor <= 4) {
			year += 2100;
			month -= 40;
		} else if (monthFactor <= 7) {
			year += 2200;
			month -= 60;
		} else {
			year += 1800;
			month -= 80;
		}
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.set(year, month, day, 0, 0, 0);
		return cal.getTime();
	}
}
