package hof.tools;

import java.util.Collection;


public class CollectionTools {

	public static Collection<Object> toCollection(Iterable<Object> iterable) {
		return (iterable instanceof Collection) ? (Collection<Object>) iterable
				: IterableTools.toCollection(iterable);
	}
	
	public static Collection<Object> toCollection(Object[] objArray) {
		return IterableTools.toCollection(objArray);
	}

}
