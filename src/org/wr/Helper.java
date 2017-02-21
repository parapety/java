package org.wr;

public class Helper {
	public static String[] extractDateFromPesel(String pesel) {
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
		return new String[] { year.toString(), (month < 10 ? "0" : "") + month.toString(),
				(day < 10 ? "0" : "") + day.toString() };
	}
}
