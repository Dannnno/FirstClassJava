import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HigherOrderFunctions {

	interface Callable {
		abstract Object run(Object... objs);
	}

	abstract static class Functor {
		abstract Object run(Object... objs);
	}
	
	abstract static class FunctorAble {
		abstract Functor returnFunction();
	}

	private static Object[] iterableAsArray(Iterable<Object> obj) {
		ArrayList<Object> tempArrayList = new ArrayList<Object>();
		for (Object next : obj) {
			tempArrayList.add(next);
		}
		return tempArrayList.toArray();
	}

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
			objList.add(o);
		}
		return objList;
	}

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

	public static Object foldr(Functor function, Object startingPoint,
			Object[] obj) {
		Object result = startingPoint;
		for (int i = obj.length - 1; i >= 0; i--) {
			result = function.run(result, obj[i]);
		}
		return result;
	}

	public static Object foldr(Functor function, Object startingPoint,
			Iterable<Object> obj) {
		Object result = startingPoint;
		Collections.reverse((List<Object>) obj);
		for (Object o : obj) {
			result = function.run(result, o);
		}
		return result;
	}

	public static Object foldl(Functor function, Object startingPoint,
			Object[] obj) {
		Object result = startingPoint;
		for (int i = 0; i < obj.length; i++) {
			result = function.run(result, obj[i]);
		}
		return result;
	}

	public static Object foldl(Functor function, Object startingPoint,
			Iterable<Object> obj) {
		Object result = startingPoint;
		for (Object o : obj) {
			result = function.run(result, o);
		}
		return result;
	}

	public static Object foldr(Functor function, Object[] obj) {
		Object startingPoint = obj[obj.length - 1];
		List<Object> subList = Arrays.asList(obj).subList(0, obj.length - 2);
		return foldr(function, startingPoint, subList.toArray());
	}

	public static Object foldl(Functor function, Object[] obj) {
		Object startingPoint = obj[0];
		List<Object> subList = Arrays.asList(obj).subList(1, obj.length - 1);
		return foldl(function, startingPoint, subList.toArray());
	}
	
	/* 
	 * These two methods are not recommended.  There isn't a good way to 
	 * get the first object from an iterable (reliably) that I've found yet,
	 * so it has to make an array out of it.
	 */
	public static Object foldr(Functor function, Iterable<Object> obj) {
		return foldr(function, iterableAsArray(obj));
	}

	public static Object foldl(Functor function, Iterable<Object> obj) {
		return foldl(function, iterableAsArray(obj));
	}
}
