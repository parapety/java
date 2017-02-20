package org.wr;

public class PeselValidator implements IValidator {

	private String input;

	final String peselPattern = "^[0-9]{11}$";

	final int[] checkSumPattern = { 9, 7, 3, 1, 9, 7, 3, 1, 9, 7 };

	public PeselValidator(String input) {
		this.input = input;
	}

	public boolean isValid() {
		if (!checkLengh()) {
			return false;
		}
		if (!checkFormat()) {
			return false;
		}
		if (!checkCheckSum()) {
			return false;
		}
		return true;
	}

	private boolean checkLengh() {
		return input.length() == 11;
	}

	private boolean checkFormat() {
		return input.matches(peselPattern);
	}

	private boolean checkCheckSum() {
		String[] tmpInput = input.split("");
		int sum = 0;
		for (int i = 0; i < checkSumPattern.length; i++) {
			sum += Integer.parseInt(tmpInput[i]) * checkSumPattern[i];
		}
		return sum % 10 == Integer.parseInt(tmpInput[tmpInput.length - 1]);
	}
}
