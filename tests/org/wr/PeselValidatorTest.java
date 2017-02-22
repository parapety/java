package org.wr;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeselValidatorTest {

	@Test
	public void shouldRetrunFalseOnWrongLength() {
		//given
		String pesel = "11111";
		PeselValidator validator = new PeselValidator(pesel);
		
		//when
		boolean valid = validator.isValid();
		
		//then
		assertFalse(valid);
	}
}
