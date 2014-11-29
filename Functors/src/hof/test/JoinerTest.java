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
public class JoinerTest {

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
	
	/**
	 * Test method for {@link hof.Joiner#Joiner(java.lang.Object, hof.Appendable)}.
	 */
	@Test
	public final void testJoinerTAppendableOfT() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#Joiner(java.lang.Object, hof.Appendable, java.lang.Object)}.
	 */
	@Test
	public final void testJoinerTAppendableOfTT() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#Joiner(java.lang.Object, hof.Appendable, java.lang.Boolean)}.
	 */
	@Test
	public final void testJoinerTAppendableOfTBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#join(java.lang.Iterable)}.
	 */
	@Test
	public final void testJoinIterableOfT() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#join(T[])}.
	 */
	@Test
	public final void testJoinTArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#join(java.lang.Object, java.lang.Object, T[])}.
	 */
	@Test
	public final void testJoinTTTArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#on(java.lang.Object, hof.Appendable)}.
	 */
	@Test
	public final void testOn() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#skipNulls(hof.Appendable)}.
	 */
	@Test
	public final void testSkipNulls() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link hof.Joiner#useForNull(hof.Appendable, java.lang.Object)}.
	 */
	@Test
	public final void testUseForNull() {
		fail("Not yet implemented"); // TODO
	}

}
