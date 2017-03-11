package org.wr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PeselProcessor {

	private IPeselHelper peselHelper = null;

	public PeselProcessor(IPeselHelper peselHelper) {
		this.peselHelper = peselHelper;
	}

	public String readBirthDate(String input) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		return sm.format(peselHelper.extractDate(input));
	}

	public String readGender(String input) {
		int gender = Integer.parseInt(input.substring(9, 10));
		return gender % 2 == 0 ? "Kobieta" : "Mężczyzna";
	}
}
