package test;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import set.UniqueElements;

public class TestUniqueElements {
	private int[] s;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}
	
	@Test
	public final void testDuplicates() {
		s = new int[3];
		s[0] = 3;
		s[1] = 3;
		s[2] = 4;
		assertEquals("Duplicate found. Expected 2, got: ", 2, UniqueElements.uniqueElements(s).length);
	}
	
	@Test
	public final void testSorting() {
		s = new int[3];
		s[0] = 9;
		s[1] = 3;
		s[2] = 4;
		assertEquals("Array not sorted. Expected 3, got: ", 3, UniqueElements.uniqueElements(s)[0]);
	}

}
