/**
 * 
 */
package hof.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hof.tools.IterableTools;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Dan
 *
 */
public class IterableToolsTest {
	
	public static ArrayList<Object> expectedList = new ArrayList<Object>();
	static {
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
	}

	/**
	 * Test method for {@link hof.tools.IterableTools#toIterable(java.util.Collection)}.
	 */
	@Test
	public final void testToIterableCollectionOfObject() {
		LinkedList<Object> a = new LinkedList<Object>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		assertEquals(expectedList, IterableTools.toIterable(a));
	}

	/**
	 * Test method for {@link hof.tools.IterableTools#toIterable(java.lang.Object[])}.
	 */
	@Test
	public final void testToIterableObjectArray() {
		Object[] a = { 1, 2, 3, 4};
		assertEquals(expectedList, IterableTools.toIterable(a));
	}

}
