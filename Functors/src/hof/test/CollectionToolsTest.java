/**
 * 
 */
package hof.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hof.tools.CollectionTools;

import java.util.Collection;
import java.util.ArrayList;
//import java.util.ServiceLoader; // an Iterable that isn't a Collection

/**
 * @author Dan
 * 
 */
public class CollectionToolsTest {

	static Collection<Object> expectedCollection = new ArrayList<Object>();
	static {
		expectedCollection.add(1);
		expectedCollection.add(2);
		expectedCollection.add(3);
		expectedCollection.add(4);
	}

	/**
	 * Test method for
	 * {@link hof.tools.CollectionTools#toCollection(java.lang.Iterable)}.
	 */
	// @Test
	// public final void testToCollectionIterableOfObject1() {
	// assertEqual(expectedCollection, CollectionTools.toCollection(new
	// ServiceLoader()));
	// There aren't many non-Collection Iterables. Once I figure out how to 
	// make a ServiceLoader I'll add this
	// }

	/**
	 * Test method for
	 * {@link hof.tools.CollectionTools#toCollection(java.lang.Iterable)}.
	 */
	@Test
	public final void testToCollectionIterableOfObject2() {
		ArrayList<Object> testList = new ArrayList<Object>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		assertEquals(expectedCollection, CollectionTools.toCollection(testList));
	}

	/**
	 * Test method for
	 * {@link hof.tools.CollectionTools#toCollection(java.lang.Object[])}.
	 */
	@Test
	public final void testToCollectionObjectArray() {
		Object[] testArray = { 1, 2, 3, 4 };
		assertEquals(expectedCollection, CollectionTools.toCollection(testArray));
	}

}
