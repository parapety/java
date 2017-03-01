package org.wr;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class PeselProcessorTest {

	@DataPoints("AAA")
	public static Set<Map.Entry<String, String>> dataProviderSet;
	static{
		
		Map<String,String> dataProvider=new HashMap<>();
		dataProvider.put("44051401458", "1944-05-14");
		dataProvider.put("85832212346", "1885-03-22");
		
		dataProvider.put("85432212344", "2185-03-22");
		dataProvider.put("85232212348", "2085-03-22");		
		dataProviderSet=dataProvider.entrySet();
	}

	@DataPoints("BBB")
	public static Set<Map.Entry<String, String>> dataProviderSetb;
	static{
		
		Map<String,String> dataProvider=new HashMap<>();
		dataProvider.put("44051401458", "1944-05-14");
		dataProvider.put("85832212346", "1885-03-22");
		dataProvider.put("85632212340", "6666-03-22");
		dataProvider.put("85432212344", "2185-03-22");
		dataProvider.put("85232212348", "2085-03-22");		
		dataProviderSetb=dataProvider.entrySet();
	}
	
	
	private PeselProcessor processor = new PeselProcessor();
	
	@Theory
	public void shouldReturnExpectedDate(@FromDataPoints("AAA")Map.Entry<String, String> entry) {
		
			// when
			String result = processor.readBirthDate((String) entry.getKey());
			// then
			assertEquals(result, entry.getValue());
	
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
