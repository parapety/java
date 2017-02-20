package org.wr;

public class PeselProcessor {

	private String input;

	public PeselProcessor(String input) {
		this.input = input;
	}

	public String readBirthDate() {
		int year = Integer.parseInt(input.substring(0, 2));
		int month = Integer.parseInt(input.substring(2, 4));
		int day = Integer.parseInt(input.substring(4, 6));
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
		return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
	}

	public String readGender() {
		int gender = Integer.parseInt(input.substring(9, 10));
		return gender % 2 == 0 ? "Kobieta" : "Mężczyzna";
	}
}
