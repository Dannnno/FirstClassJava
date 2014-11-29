package hof.test;
import static org.junit.Assert.*;
import hof.Filter;
import hof.Predicate;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Dan
 * 
 */
public class FilterTest {
	
	static class EvenChecker extends Predicate {
		
		static class EvenChecker2 extends Predicate {
			
			@Override
			public Boolean run(Object... args) {
				return ((Integer) args[0])%2 == 0 && ((Integer) args[1])%2 == 0;
			}
		}
		@Override
		public Boolean run(Object... args) {
			return ((Integer) args[0])%2 == 0;
		}
	}

	static Predicate predicate1 = new EvenChecker();
	static Predicate predicate2 = new EvenChecker.EvenChecker2();
	static Object[] testArray = { 1, 2, 3, 4 };
	static Object[] expectedArray = { 2, 4 };
	static ArrayList<Object> testList = new ArrayList<Object>();
	static ArrayList<Object> expectedList = new ArrayList<Object>();
	static HashMap<Object, Object> testMap = new HashMap<Object, Object>();
	static {
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		expectedList.add(2);
		expectedList.add(4);
		testMap.put(1, 2);
		testMap.put(2, 3);
		testMap.put(3, 4);
		testMap.put(4, 5);
	}

	/**
	 * Test method for {@link Filter#filter(Functor, java.lang.Object[])}.
	 */
	@Test
	public final void testFilterFunctorObjectArray() {
		assertArrayEquals(expectedArray, Filter.filter(predicate1, testArray));
	}

	/**
	 * Test method for {@link Filter#filter(Functor, java.lang.Iterable)}.
	 */
	@Test
	public final void testFilterFunctorIterableOfObject() {
		assertArrayEquals(expectedList.toArray(), Filter.filter(predicate1, testList).toArray());
	}

	/**
	 * Test method for {@link Filter#filter(Functor, java.util.Map, Boolean)}.
	 */
	@Test
	public final void testFilterFunctorMapOfObjectObjectBoolean1() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		assertEquals(expectedMap, Filter.filter(predicate2, testMap, true));
	}

	/**
	 * Test method for {@link Filter#filter(Functor, java.util.Map, Boolean)}.
	 */
	@Test
	public final void testFilterFunctorMapOfObjectObjectBoolean2() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		assertEquals(expectedMap, Filter.filter(predicate1, testMap, false));
	}

	/**
	 * Test method for {@link Filter#kFilter(Functor, java.util.Map)}.
	 */
	@Test
	public final void testKFilter() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		expectedMap.put(2, 3); expectedMap.put(4, 5);
		assertEquals(expectedMap, Filter.kFilter(predicate1, testMap));
	}

	/**
	 * Test method for {@link Filter#vFilter(Functor, java.util.Map)}.
	 */
	@Test
	public final void testVFilter() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		expectedMap.put(1, 2); expectedMap.put(3, 4);
		assertEquals(expectedMap, Filter.vFilter(predicate1, testMap));
	}

}
