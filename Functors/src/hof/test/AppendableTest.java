/**
 * 
 */
package hof.test;

import hof.Appendable;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dan
 * 
 */
public class AppendableTest {

	private static class StringyBuilder extends Appendable<String> {

		public Collection<String> list;

		public StringyBuilder() {
			this.list = new ArrayList<String>();
		}

		@Override
		public void append(Object o) {
			this.list.add((String) o);
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
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Appendable#appendTo(java.lang.Iterable)}.
	 */
	@Test
	public final void testAppendToIterableOfObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Appendable#appendTo(java.lang.Object[])}.
	 */
	@Test
	public final void testAppendToObjectArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link hof.Appendable#appendTo(java.lang.Object, java.lang.Object, java.lang.Object[])}
	 * .
	 */
	@Test
	public final void testAppendToObjectObjectObjectArray() {
		fail("Not yet implemented"); // TODO
	}

}
