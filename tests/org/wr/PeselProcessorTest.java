package org.wr;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class PeselProcessorTest {

	@Test
	public void shouldReturnExpectedDate() {
		// given
		HashMap<String, String> dataProvider = new HashMap<String, String>();
		dataProvider.put("44051401458", "1944-05-14");
		dataProvider.put("85832212346", "1885-03-22");
		dataProvider.put("85632212340", "2285-03-22");
		dataProvider.put("85432212344", "2185-03-22");
		dataProvider.put("85232212348", "2085-03-22");
		PeselProcessor processor = new PeselProcessor();

		Set set = dataProvider.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			// when
			String result = processor.readBirthDate((String) mentry.getKey());
			// then
			assertEquals(result, mentry.getValue());
		}
	}

	@Test
	public void shouldReturnMen() {
		// given
		PeselProcessor processor = new PeselProcessor();
		// when
		String gender = processor.readGender("44051401458");
		// then
		assertEquals("Mężczyzna", gender);
	}
	
	@Test
	public void shouldReturnWomen() {
		// given
		PeselProcessor processor = new PeselProcessor();
		// when
		String gender = processor.readGender("44051401441");
		// then
		assertEquals("Kobieta", gender);
	}
}
