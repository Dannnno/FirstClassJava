/**
 * 
 */
package hof.tools;

import java.util.Collection;

/**
 * @author Dan
 * 
 */
public class ArrayTools {
	
	public static Object[] toArray(Collection<Object> collection) {
		return collection.toArray();
	}
	
	public static Object[] toArray(Iterable<Object> iterable) {
		return CollectionTools.toCollection(iterable).toArray();
	}

}
