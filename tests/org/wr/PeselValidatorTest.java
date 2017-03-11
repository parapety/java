package org.wr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class PeselValidatorTest {

	private PeselValidator validator;
	@Mock private IPeselHelper peselHelper;

	@Before
	public void setUp() throws Exception {
		validator = new PeselValidator(peselHelper);
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
		when(peselHelper.extractDate("44544444447")).thenThrow(new RuntimeException());
		boolean valid = validator.isValid(pesel);
		// then
		assertFalse(valid);
	}

	@Test
	public void shouldRetrunTrueOnWalidPesel() {
		// given
		String pesel = "44051401458";
		// when
		when(peselHelper.extractDate("44051401458")).thenReturn(new Date());
		boolean valid = validator.isValid(pesel);
		// then
		assertTrue(valid);
	}
}
