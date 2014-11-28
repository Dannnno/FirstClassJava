/**
 * 
 */
package hof.tools;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Dan
 * 
 */
public class ArrayTools {

	public static Object[] toArray(Collection<Object> collection) {
		return collection.toArray();
	}

	public static Object[] toArray(Iterable<Object> iterable) {
		Object[] retArray;
		if (iterable instanceof Collection<?>) {
			retArray = new Object[((Collection<Object>) iterable).size()];
		} else {
			Iterator<Object> i = iterable.iterator();
			int count = 0;
			for (; i.hasNext(); ++count, i.next());
			retArray = new Object[count];
		}
		int i=0;
		for(Object o: iterable) {
			retArray[i] = o;
			i++;
		}
		return retArray;
	}

}
