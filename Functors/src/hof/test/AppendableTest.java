/**
 * 
 */
package hof.test;

import static org.junit.Assert.*;
import hof.Appendable;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * @author Dan
 * 
 */
public class AppendableTest {

	public static class StringyBuilder extends Appendable<String> {

		public Collection<String> list;

		public StringyBuilder() {
			this.list = new ArrayList<String>();
		}

		@Override
		public void append(String str) {
			this.list.add(str);
		}
	}

	static Appendable<String> testAppendable = new StringyBuilder();
	static {
		testAppendable.append("hello");
		testAppendable.append("World");
	}

	/**
	 * Test method for {@link hof.Appendable#iterator()}.
	 */
	@Test
	public final void testIterator() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hello");
		list1.add("World");
		assertEquals(list1.iterator(), testAppendable.iterator());
	}

	/**
	 * Test method for {@link hof.Appendable#append(java.lang.Object)}.
	 */
	@Test
	public final void testAppend() {
		Appendable<String> test2 = new StringyBuilder();
		test2.append("hello");
		test2.append("World");
		assertEquals(test2.list, testAppendable.list);
	}

	/**
	 * Test method for {@link hof.Appendable#appendTo(java.lang.Iterable)}.
	 */
	@Test
	public final void testAppendToIterableOfT() {
		Appendable<String> test2 = new StringyBuilder();
		ArrayList<String> appending = new ArrayList<String>();
		appending.add("hello");
		appending.add("World");
		test2.appendTo(appending);
		assertEquals(test2.list, testAppendable.list);
	}

	/**
	 * Test method for {@link hof.Appendable#appendTo(T[])}.
	 */
	@Test
	public final void testAppendToTArray() {
		Appendable<String> test2 = new StringyBuilder();
		String[] testArray = { "hello", "World" };
		test2.appendTo(testArray);
		assertEquals(test2.list, testAppendable.list);
	}

	/**
	 * Test method for
	 * {@link hof.Appendable#appendTo(java.lang.Object, java.lang.Object, T[])}.
	 */
	@Test
	public final void testAppendToTTTArray() {
		Appendable<String> test2 = new StringyBuilder();
		test2.appendTo("hello", "World");
		assertEquals(test2.list, testAppendable.list);
	}

	/**
	 * Test method for {@link hof.Appendable#toString()}.
	 */
	@Test
	public final void testToString() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("hello");
		testList.add("World");
		assertEquals(testList.toString(), testAppendable.toString());
	}
	
	/**
	 * Test method for {@link hof.Appendable#getType()}.
	 */
	@Test
	public final void testGetType() {
		assertEquals(testAppendable.getType(), "".getClass());
	}

}
