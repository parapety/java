package org.wr;

import java.util.Date;

public class PeselProcessor {

	private String input;

	public PeselProcessor(String input) {
		this.input = input;
	}

	public Date readBirthDate() {
		return PeselHelper.extractDate(input);
	}

	public String readGender() {
		int gender = Integer.parseInt(input.substring(9, 10));
		return gender % 2 == 0 ? "Kobieta" : "Mężczyzna";
	}
}
