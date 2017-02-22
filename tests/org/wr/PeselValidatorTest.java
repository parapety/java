package org.wr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeselValidatorTest {

	private PeselValidator validator;

	@Before
	public void setUp() throws Exception {
		validator = new PeselValidator();
	}

	@Test
	public void shouldRetrunFalseOnWrongLength() {
		// given
		String pesel = "11111";
		// when
		boolean valid = validator.isValid(pesel);
		// then
		assertFalse(valid);
	}

	@Test
	public void shouldRetrunFalseOnWrongFormat() {
		// given
		String pesel = "afsregdtfhr";
		// when
		boolean valid = validator.isValid(pesel);
		// then
		assertFalse(valid);
	}

	@Test
	public void shouldRetrunFalseOnWrongChecksum() {
		// given
		String pesel = "11111111111";
		// when
		boolean valid = validator.isValid(pesel);
		// then
		assertFalse(valid);
	}

	@Test
	public void shouldRetrunFalseOnWrongDate() {
		// given
		String pesel = "44544444447";
		// when
		boolean valid = validator.isValid(pesel);
		// then
		assertFalse(valid);
	}

	@Test
	public void shouldRetrunTrueOnWalidPesel() {
		// given
		String pesel = "44051401458";
		// when
		boolean valid = validator.isValid(pesel);
		// then
		assertTrue(valid);
	}
}
