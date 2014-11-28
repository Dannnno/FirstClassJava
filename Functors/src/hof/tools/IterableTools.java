package hof.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class IterableTools {

	
	public static Iterable<Object> toIterable(Collection<Object> obj) {
		List<Object> retIterable = new ArrayList<Object>();
		for(Object o: obj) {
			retIterable.add(o);
		}
		return retIterable;
	}
	
	public static Iterable<Object> toIterable(Object[] obj) {
		return Arrays.asList(obj);
	}
	
}
