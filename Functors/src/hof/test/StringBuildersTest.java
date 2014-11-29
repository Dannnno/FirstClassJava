/**
 * 
 */
package hof.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hof.tools.StringBuilders;

import java.util.ArrayList;
/**
 * @author Dan
 *
 */
public class StringBuildersTest {
	
	static String expectedString = "Hello, World";

	/**
	 * Test method for {@link hof.tools.StringBuilders#appendTo(java.lang.StringBuilder, java.lang.Iterable)}.
	 */
	@Test
	public final void testAppendToStringBuilderIterableOfString() {
		ArrayList<String> listToAdd = new ArrayList<String>();
		listToAdd.add("Hello,");
		listToAdd.add(" World");
		StringBuilder sb = new StringBuilder();
		sb = StringBuilders.appendTo(sb, listToAdd);
		assertEquals(expectedString, sb.toString());
	}

	/**
	 * Test method for {@link hof.tools.StringBuilders#appendTo(java.lang.StringBuilder, java.lang.String[])}.
	 */
	@Test
	public final void testAppendToStringBuilderStringArray() {
		String[] arrayToAdd = { "Hell", "o, World" };
		StringBuilder sb = new StringBuilder();
		sb = StringBuilders.appendTo(sb, arrayToAdd);
		assertEquals(expectedString, sb.toString());
	}

	/**
	 * Test method for {@link hof.tools.StringBuilders#appendTo(java.lang.StringBuilder, java.lang.String, java.lang.String, java.lang.String[])}.
	 */
	@Test
	public final void testAppendToStringBuilderStringStringStringArray() {
		StringBuilder sb = new StringBuilder();
		sb = StringBuilders.appendTo(sb, "Hell", "o, ", "World");
		assertEquals(expectedString, sb.toString());
	}

}
