package hof.test;
import static org.junit.Assert.*;

import org.junit.Test;

import hof.Functor;
import hof.MapF;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Dan
 * 
 */
public class MapFTest {
	
	public static class Adder extends Functor {

		@Override
		public Object run(Object... objects) {
			return (Integer) objects[0] + new Integer(1);
		}
	}

	static Functor function = new Adder();
	static Object[] testArray = { 1, 2, 3, 4 };
	static Object[] expectedArray = { 2, 3, 4, 5 };
	static ArrayList<Object> testList = new ArrayList<Object>();
	static ArrayList<Object> expectedList = new ArrayList<Object>();
	static HashMap<Object, Object> testMap = new HashMap<Object, Object>();
	static {
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(5);
		testMap.put(1, 2);
		testMap.put(2, 3);
		testMap.put(3, 4);
		testMap.put(4, 5);
	}

	/**
	 * Test method for {@link MapF#map(Functor, java.lang.Object[])}.
	 */
	@Test
	public final void testMapFunctorObjectArray() {
		Object[] resultArray = MapF.map(function, testArray);
		assertArrayEquals(expectedArray, resultArray);
	}

	/**
	 * Test method for {@link MapF#map(Functor, java.lang.Iterable)}.
	 */
	@Test
	public final void testMapFunctorIterableOfObject() {
		ArrayList<Object> result = (ArrayList<Object>) MapF.map(function,
				testList);
		assertArrayEquals(expectedList.toArray(), result.toArray());
	}

	/**
	 * Test method for {@link MapF#map(Functor, java.util.Map)}.
	 */
	@Test
	public final void testMapFunctorMapOfObjectObject() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		expectedMap.put(2, 3);
		expectedMap.put(3, 4);
		expectedMap.put(4, 5);
		expectedMap.put(5, 6);
		HashMap<Object, Object> resultMap = (HashMap<Object, Object>) MapF.map(
				function, testMap);
		assertEquals(expectedMap, resultMap);
	}

	/**
	 * Test method for {@link MapF#kMap(Functor, java.util.Map)}.
	 */
	@Test
	public final void testKMap() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		expectedMap.put(2, 2);
		expectedMap.put(3, 3);
		expectedMap.put(4, 4);
		expectedMap.put(5, 5);
		HashMap<Object, Object> resultMap = (HashMap<Object, Object>) MapF.kMap(
				function, testMap);
		assertEquals(expectedMap, resultMap);
	}

	/**
	 * Test method for {@link MapF#vMap(Functor, java.util.Map)}.
	 */
	@Test
	public final void testVMap() {
		HashMap<Object, Object> expectedMap = new HashMap<Object, Object>();
		expectedMap.put(1, 3);
		expectedMap.put(2, 4);
		expectedMap.put(3, 5);
		expectedMap.put(4, 6);
		HashMap<Object, Object> resultMap = (HashMap<Object, Object>) MapF.vMap(
				function, testMap);
		assertEquals(expectedMap, resultMap);
	}

}
