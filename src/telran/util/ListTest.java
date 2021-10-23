package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
private List<Integer> numbers;
private List<String> strings;
Integer initialNumbers[] = {10, 20, 40};
String initialStrings[] = {"name1", "name2"};
	@BeforeEach
	void setUp() throws Exception {
		numbers = getInitialNumbers();
		strings = getInitialStrings();
	}

	private List<String> getInitialStrings() {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < initialStrings.length; i++) {
			res.add(initialStrings[i]);
		}
		return res;
	}

	private List<Integer> getInitialNumbers() {
		List<Integer> res = new ArrayList<>(1);
		for (int i = 0; i < initialNumbers.length; i++) {
			res.add(initialNumbers[i]);
		}
		return res;
	}

	@Test
	void testGet() {
		assertEquals(10, numbers.get(0));
		assertEquals("name1", strings.get(0));
		assertEquals(null, numbers.get(-1));
		assertEquals(null, numbers.get(3));
	}
	
	@Test
	void testAddByIndex() {
		// V.R. The test for checking ArrayList.java, line 34 is required.
		// Something like following
		// assertEquals(false, strings.add(-1, "name3"));
		// 
		assertEquals(true, numbers.add(1, 15));
		assertEquals(true, strings.add(1, "name3"));
		assertEquals(true, numbers.add(3, 15));
		// V.R. Why emptyList is required? What is impossible without it?
		List<Integer> emptyList = new ArrayList<>();
		assertEquals(false, emptyList.add(1, 15));
		assertEquals(false, numbers.add(numbers.size() + 1, 15));
		assertEquals(false, strings.add(strings.size() + 1, "name4"));
		// V.R. Return codes are tested. It is clear.
		// Why places of certain elements aren't checked?
	}
	
	@Test
	void testRemove() {
		assertEquals(10, numbers.remove(0));
		assertEquals("name1", strings.remove(0));
		assertEquals(null, strings.remove(8));
		assertEquals(40, numbers.remove(1));
		assertEquals(null, numbers.remove(2));
		assertEquals(null, numbers.remove(-3));
		// V.R. Return codes are tested. It is clear.
		// Why places of certain elements aren't checked?
	}

}
