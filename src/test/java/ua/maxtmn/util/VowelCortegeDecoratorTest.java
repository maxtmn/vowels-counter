package ua.maxtmn.util;

import junit.framework.TestCase;

public class VowelCortegeDecoratorTest extends TestCase {

	public void test_type() throws Exception {
		assertNotNull(VowelCortegeDecorator.class);
	}

	public void test_instantiation_null() throws Exception {
		String result = null;
		VowelCortegeDecorator target = new VowelCortegeDecorator(result);
		assertNotNull(target);
	}

	public void test_instantiation_empty() throws Exception {
		String result = "";
		VowelCortegeDecorator target = new VowelCortegeDecorator(result);
		assertNotNull(target);
	}

	public void test_toString_A$() throws Exception {
		String result = "decorate me with paretneses";
		VowelCortegeDecorator target = new VowelCortegeDecorator(result);
		String actual = target.toString();
		String expected = "("+result+")";
		assertEquals(expected, actual);
	}
	
	public void test_toString_B$() throws Exception {
		String change ="[a=b]";
		String no_change=" decorate me with paretneses";
		String result = change + no_change;
		
		VowelCortegeDecorator target = new VowelCortegeDecorator(result);
		String actual = target.toString();
		String expected = "({a, b}"+no_change+")";
		assertEquals(expected, actual);
	}

}
