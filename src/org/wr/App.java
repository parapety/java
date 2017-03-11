package org.wr;

import java.io.IOException;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] input = new byte[11];
		try {
			System.out.print("Wprowadź PESEL: ");
			System.in.read(input);
		} catch (IOException e) {
			// Pytanie co tu powinno sie znalezc ?
			e.printStackTrace();
		}
		String pesel = new String(input).trim();
		IValidator validator = new PeselValidator(PeselHelper.getInstance());
		if (validator.isValid(pesel)) {
			PeselProcessor processor = new PeselProcessor(PeselHelper.getInstance());
			System.out.println("PESEL Poprawny");
			System.out.println("Data urodzenia: " + processor.readBirthDate(pesel));
			System.out.println("Płeć: " + processor.readGender(pesel));
		} else {
			System.out.println("Błędny PESEL");
		}
	}
}
