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
		assertEquals(true, numbers.add(1, 15));
		assertEquals(true, strings.add(1, "name3"));
		assertEquals(true, numbers.add(3, 15));
		List<Integer> emptyList = new ArrayList<>();
		assertEquals(false, emptyList.add(1, 15));
		assertEquals(false, numbers.add(numbers.size() + 1, 15));
		assertEquals(false, strings.add(strings.size() + 1, "name4"));
	}
	
	@Test
	void testRemove() {
		assertEquals(10, numbers.remove(0));
		assertEquals("name1", strings.remove(0));
		assertEquals(null, strings.remove(8));
		assertEquals(40, numbers.remove(1));
		assertEquals(null, numbers.remove(2));
		assertEquals(null, numbers.remove(-3));
	}
	@Test
	void testAddAtIndex() {
		int inserted0 = 100;
		int inserted2 = -8;
		int inserted4 = 1000;
		Integer[] expected = {inserted0, 10, inserted2, 20, 40, inserted4};
		assertEquals(true, numbers.add(0, inserted0));
		assertEquals(true, numbers.add(2, inserted2));
		assertEquals(true, numbers.add(5, inserted4));
		assertArrayEquals(expected, getArrayFromList(numbers));
		assertEquals(false, numbers.add(7, 1000));
		assertEquals(false, numbers.add(-1, 1000));
	}
	@Test
	void testRemove() {
		Integer expected0[] = {20, 40};
		Integer expected1[] = {20};
		assertEquals(null, numbers.remove(3));
		assertEquals(null, numbers.remove(-1));
		assertEquals(10, numbers.remove(0));
		assertArrayEquals(expected0, getArrayFromList(numbers));
		assertEquals(40, numbers.remove(1));
		assertArrayEquals(expected1, getArrayFromList(numbers));
		
	}
	@Test 
	void testSize() {
		assertEquals(initialNumbers.length, numbers.size());
		numbers.add(100);
		assertEquals(initialNumbers.length + 1, numbers.size());
		numbers.remove(0);
		assertEquals(initialNumbers.length, numbers.size());
	}
	@SuppressWarnings("unchecked")
	private <T> T[] getArrayFromList(List<T> list) {
		int size = list.size();
		T[] res = (T[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
