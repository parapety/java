package org.wr;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PeselProcessorTest {

	@Mock
	private IPeselHelper peselHelper;
	private PeselProcessor processor;

	
	@Before public void setUp() {
		processor = new PeselProcessor(peselHelper); 
	}

	@Test
	public void shouldReturnExpectedDateInExpectedFormat() {
		String pesel = "44051401458";
		// when
		when(peselHelper.extractDate("44051401458"))
				.thenReturn(new Calendar.Builder().setDate(1944, 4, 14).build().getTime());
		String result = processor.readBirthDate(pesel);
		// then
		assertEquals(result, "1944-05-14");
	}

	@Test
	public void shouldReturnMen() {
		// given
		PeselProcessor processor = new PeselProcessor(peselHelper);
		// when
		String gender = processor.readGender("44051401458");
		// then
		assertEquals("Mężczyzna", gender);
	}

	@Test
	public void shouldReturnWomen() {
		// given
		PeselProcessor processor = new PeselProcessor(peselHelper);
		// when
		String gender = processor.readGender("44051401441");
		// then
		assertEquals("Kobieta", gender);
	}
}
