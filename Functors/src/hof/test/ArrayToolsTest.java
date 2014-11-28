/**
 * 
 */
package hof.test;
import hof.tools.ArrayTools;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dan
 *
 */
public class ArrayToolsTest {
	
	public static Object[] expectedArray = {1, 2, 3, 4};

	/**
	 * Test method for {@link hof.tools.ArrayTools#toArray(java.util.Collection)}.
	 */
	@Test
	public final void testToArrayCollectionOfObject() {
		Collection<Object> testCollection = new ArrayList<Object>();
		testCollection.add(1); testCollection.add(2); testCollection.add(3); testCollection.add(4);
		assertArrayEquals(expectedArray, ArrayTools.toArray(testCollection));
	}

	/**
	 * Test method for {@link hof.tools.ArrayTools#toArray(java.lang.Iterable)}.
	 */
	@Test
	public final void testToArrayIterableOfObject() {
		List<Object> testList = new ArrayList<Object>();
		testList.add(1); 
		testList.add(2); 
		testList.add(3); 
		testList.add(4); 
		assertArrayEquals(expectedArray, ArrayTools.toArray(testList));
	}

}
