package org.wr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeselValidator implements IValidator {

	final String peselPattern = "^[0-9]{11}$";

	final int[] checkSumPattern = { 9, 7, 3, 1, 9, 7, 3, 1, 9, 7 };

	public boolean isValid(String input) {
		if (checkLengh(input) && checkFormat(input) && checkCheckSum(input) && checkDate(input)) {
			return true;
		}
		return false;
	}

	private boolean checkLengh(String input) {
		return input.length() == 11;
	}

	private boolean checkFormat(String input) {
		return input.matches(peselPattern);
	}

	private boolean checkCheckSum(String input) {
		String[] tmpInput = input.split("");
		int sum = 0;
		for (int i = 0; i < checkSumPattern.length; i++) {
			sum += Integer.parseInt(tmpInput[i]) * checkSumPattern[i];
		}
		return sum % 10 == Integer.parseInt(tmpInput[tmpInput.length - 1]);
	}

	private boolean checkDate(String input) {
		try {
			PeselHelper.extractDate(input);
		} catch (RuntimeException e) {
			return false;
		}
		return true;
	}
}
