package org.wr;

public class PeselProcessor {

	private String input;

	public PeselProcessor(String input) {
		this.input = input;
	}

	public String readBirthDate() {
		return String.join("-", Helper.extractDateFromPesel(input));
	}

	public String readGender() {
		int gender = Integer.parseInt(input.substring(9, 10));
		return gender % 2 == 0 ? "Kobieta" : "Mężczyzna";
	}
}
