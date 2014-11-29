package hof;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Filter {

	public static Object[] filter(Predicate predicate, Object[] obj) {
		List<Object> filteredList = new ArrayList<Object>();
		for (int i = 0; i < obj.length; i++) {
			if (predicate.run(obj[i])) {
				filteredList.add(obj[i]);
			}
		}
		return filteredList.toArray();
	}

	public static List<Object> filter(Predicate predicate, Iterable<Object> obj) {
		List<Object> filteredList = new ArrayList<Object>();
		for (Object o : obj) {
			if (predicate.run(o)) {
				filteredList.add(o);
			}
		}
		return filteredList;
	}

	private static Map<Object, Object> filter(Predicate predicate,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if (predicate.run(entry.getKey(), entry.getValue())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}

	public static Map<Object, Object> filter(Predicate predicate,
			Map<Object, Object> obj, boolean twoArgs) {
		if (twoArgs) {
			return filter(predicate, obj);
		} else {
			Map<Object, Object> retMap = new Hashtable<Object, Object>();
			for (Map.Entry<Object, Object> entry : obj.entrySet()) {
				if (predicate.run(entry.getKey())
						&& (Boolean) predicate.run(entry.getValue())) {
					retMap.put(entry.getKey(), entry.getValue());
				}
			}
			return retMap;
		}
	}

	public static Map<Object, Object> kFilter(Predicate predicate,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if (predicate.run(entry.getKey())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}

	public static Map<Object, Object> vFilter(Predicate predicate,
			Map<Object, Object> obj) {
		Map<Object, Object> retMap = new Hashtable<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			if (predicate.run(entry.getValue())) {
				retMap.put(entry.getKey(), entry.getValue());
			}
		}
		return retMap;
	}
}
