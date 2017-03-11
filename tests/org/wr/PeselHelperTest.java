package org.wr;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(Theories.class)
public class PeselHelperTest {

	@DataPoints
	public static Set<Map.Entry<String, Date>> dataProviderSet;
	static {
		Map<String, Date> dataProvider = new HashMap<>();
		dataProvider.put("44051401458", new Calendar.Builder().setDate(1944, 4, 14).build().getTime());
		dataProvider.put("85832212346", new Calendar.Builder().setDate(1885, 2, 22).build().getTime());
		dataProvider.put("85432212344", new Calendar.Builder().setDate(2185, 2, 22).build().getTime());
		dataProvider.put("85232212348", new Calendar.Builder().setDate(2085, 2, 22).build().getTime());
		dataProvider.put("85632212344", new Calendar.Builder().setDate(2285, 2, 22).build().getTime());
		dataProviderSet = dataProvider.entrySet();
	}

	@Theory
	public void shouldReturnExpectedDate(Map.Entry<String, Date> entry) {
		// when
		Date result = PeselHelper.getInstance().extractDate((String) entry.getKey());
		// then
		assertTrue(Math.abs(result.getTime() - entry.getValue().getTime()) < 1000);
	}
}
