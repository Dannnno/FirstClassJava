package hof.tools;

import java.util.ArrayList;
import java.util.List;


public class IterableTools {

	
	public static List<Object> toCollection(Iterable<Object> iterable) {
		List<Object> retList = new ArrayList<Object>();
		for(Object o: iterable) {
			retList.add(o);
		}
		return retList;
	}
	
	public static List<Object> toCollection(Object[] objArray) {
		List<Object> retList = new ArrayList<Object>();
		for(Object o: objArray) {
			retList.add(o);
		}
		return retList;
	}
	
}
