/**
 * 
 */
package hof.test;

import static org.junit.Assert.*;
import hof.Functor;
import hof.Summer;
import hof.Reduce;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * @author Dan
 * 
 */
public class ReduceTest {
	
	static Functor function = new Summer();
	static Object[] testArray = { 1, 2, 3, 4 };
	static ArrayList<Object> testList = new ArrayList<Object>();
	static HashMap<Object, Object> testMap = new HashMap<Object, Object>();
	static {
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
	}

	/**
	 * Test method for
	 * {@link hof.Reduce#foldr(hof.Functor, java.lang.Object, java.lang.Object[])}
	 * .
	 */
	@Test
	public final void testFoldrFunctorObjectObjectArray() {
		assertEquals((Integer) 10, Reduce.foldr(function, 0, testArray));
		Object[] valArray = { 1, 2, 3, 4 };
		assertArrayEquals(testArray, valArray);
	}

	/**
	 * Test method for
	 * {@link hof.Reduce#foldr(hof.Functor, java.lang.Object, java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFoldrFunctorObjectIterableOfObject() {
		assertEquals((Integer) 10, Reduce.foldr(function, 0, testList));
	}

	/**
	 * Test method for
	 * {@link hof.Reduce#foldl(hof.Functor, java.lang.Object, java.lang.Object[])}
	 * .
	 */
	@Test
	public final void testFoldlFunctorObjectObjectArray() {
		assertEquals((Integer) 10, Reduce.foldl(function, 0, testArray));
	}

	/**
	 * Test method for
	 * {@link hof.Reduce#foldl(hof.Functor, java.lang.Object, java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFoldlFunctorObjectIterableOfObject() {
		assertEquals((Integer) 10, Reduce.foldl(function, 0, testList));
	}

	/**
	 * Test method for {@link hof.Reduce#foldr(hof.Functor, java.lang.Object[])}
	 * .
	 */
	@Test
	public final void testFoldrFunctorObjectArray() {
		assertEquals((Integer) 10, Reduce.foldr(function, testArray));
	}

	/**
	 * Test method for {@link hof.Reduce#foldl(hof.Functor, java.lang.Object[])}
	 * .
	 */
	@Test
	public final void testFoldlFunctorObjectArray() {
		assertEquals((Integer) 10, Reduce.foldl(function, testArray));
	}

	/**
	 * Test method for {@link hof.Reduce#foldr(hof.Functor, java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFoldrFunctorIterableOfObject() {
		assertEquals((Integer) 10, Reduce.foldr(function, testList));
	}

	/**
	 * Test method for {@link hof.Reduce#foldl(hof.Functor, java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFoldlFunctorIterableOfObject() {
		assertEquals((Integer) 10, Reduce.foldl(function, testList));
	}

}
