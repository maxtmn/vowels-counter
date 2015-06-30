package ua.maxtmn.executor;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

public class VowelsCounterTest extends TestCase {

	private static final Collection<String> INPUT = Arrays.asList("The",
			"time", "traveller");
	private static final Collection<String> expected = Arrays.asList(
			"{a, e}, 9 -> 3.0", "{e, i}, 4 -> 2.0", "{e}, 3 -> 3.0");

	public void test_type() throws Exception {
		assertNotNull(VowelsCounter.class);
	}

	public void test_instantiation() throws Exception {
		VowelsCounter target = new VowelsCounter();
		assertNotNull(target);
	}

	public void test_countAverageVowelsInWords_A$Collection() throws Exception {
		Collection<String> actual = VowelsCounter
				.countAverageVowelsInWords(INPUT);
		assertTrue(actual.size() == expected.size());
		assertEquals(expected.toString(), actual.toString());

	}

}
