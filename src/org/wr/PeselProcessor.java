package org.wr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PeselProcessor {

	public String readBirthDate(String input) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		return sm.format(PeselHelper.extractDate(input));
	}

	public String readGender(String input) {
		int gender = Integer.parseInt(input.substring(9, 10));
		return gender % 2 == 0 ? "Kobieta" : "Mężczyzna";
	}
}
