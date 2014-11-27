package hof;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapF {

	public static Object[] map(Functor function, Object[] obj) {
		Object[] newList = new Object[obj.length];
		for (int i = 0; i < obj.length; i++) {
			newList[i] = function.run(obj[i]);
		}
		return newList;
	}

	public static List<Object> map(Functor function, Iterable<Object> obj) {
		List<Object> objList = new ArrayList<Object>();
		for (Object o : obj) {
			objList.add(function.run(o));
		}
		return objList;
	}

	public static Map<Object, Object> map(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			returnMap.put(function.run(entry.getKey()),
					function.run(entry.getValue()));
		}
		return returnMap;
	}

	public static Map<Object, Object> kMap(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			returnMap.put(function.run(entry.getKey()), entry.getValue());
		}
		return returnMap;
	}

	public static Map<Object, Object> vMap(Functor function,
			Map<Object, Object> obj) {
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		for (Map.Entry<Object, Object> entry : obj.entrySet()) {
			returnMap.put(entry.getKey(), function.run(entry.getValue()));
		}
		return returnMap;
	}
}
