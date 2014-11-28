package hof.tools;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTools {

	public static Collection<Object> toCollection(Iterable<Object> iterable) {
		return (iterable instanceof Collection) ? (Collection<Object>) iterable
				: toCollection(iterable, false);
	}

	private static Collection<Object> toCollection(Iterable<Object> iterable,
			boolean whatever) {
		Collection<Object> retList = new ArrayList<Object>();
		for (Object o : iterable) {
			retList.add(o);
		}
		return retList;
	}

	public static Collection<Object> toCollection(Object[] objArray) {
		Collection<Object> retList = new ArrayList<Object>();
		for(Object o : objArray) {
			retList.add(o);
		}
		return retList;
	}

}
