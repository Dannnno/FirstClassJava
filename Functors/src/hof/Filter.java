package hof;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Filter {

	public static Object[] filter(Functor function, Object[] obj) {
		List<Object> filteredList = new ArrayList<Object>();
		for (int i = 0; i < obj.length; i++) {
			if ((Boolean) function.run(obj[i])) {
				filteredList.add(obj[i]);
			}
		}
		return filteredList.toArray();
	}

	public static List<Object> filter(Functor function, Iterable<Object> obj) {
		List<Object> filteredList = new ArrayList<Object>();
		for (Object o : obj) {
			if ((Boolean) function.run(o)) {
				filteredList.add(o);
			}
		}
		return filteredList;
	}

	private static Map<Object, Object> filter(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if ((Boolean) function.run(entry.getKey(), entry.getValue())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}

	public static Map<Object, Object> filter(Functor function,
			Map<Object, Object> obj, boolean twoArgs) {
		if (twoArgs) {
			return filter(function, obj);
		} else {
			Map<Object, Object> retMap = new Hashtable<Object, Object>();
			for (Map.Entry<Object, Object> entry : obj.entrySet()) {
				if ((Boolean) function.run(entry.getKey())
						&& (Boolean) function.run(entry.getValue())) {
					retMap.put(entry.getKey(), entry.getValue());
				}
			}
			return retMap;
		}
	}

	public static Map<Object, Object> kFilter(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if ((Boolean) function.run(entry.getKey())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}

	public static Map<Object, Object> vFilter(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if ((Boolean) function.run(entry.getValue())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}
}
