package ua.maxtmn.executor;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

public class VowelsCounterTest extends TestCase {

	private static final Collection<String> INPUT = Arrays.asList("Platon",
			"made", "bamboo", "boats");
	private static final Collection<String> expected = Arrays.asList(
			"({a, e}, 4) -> 2.0", "({a, o}, 5) -> 2.0", "({a, o}, 6) -> 2.5");

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
