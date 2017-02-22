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
		IValidator validator = new PeselValidator(pesel);
		if (validator.isValid()) {
			PeselProcessor processor = new PeselProcessor(pesel);
			System.out.println("PESEL Poprawny");
			System.out.println("Data urodzenia: " + processor.readBirthDate());
			System.out.println("Płeć: " + processor.readGender());
		} else {
			System.out.println("Błędny PESEL");
		}
	}
}
