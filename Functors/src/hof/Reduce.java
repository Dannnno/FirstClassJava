package hof;
import hof.tools.ArrayTools;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Reduce {
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
		List<Object> subList = Arrays.asList(obj).subList(0, obj.length - 1);
		return foldr(function, startingPoint, subList.toArray());
	}

	public static Object foldl(Functor function, Object[] obj) {
		Object startingPoint = obj[0];
		List<Object> subList = Arrays.asList(obj).subList(1, obj.length);
		return foldl(function, startingPoint, subList.toArray());
	}

	/*
	 * These two methods are not recommended. There isn't a good way to get the
	 * first object from an iterable (reliably) that I've found yet, so it has
	 * to make an array out of it.
	 */
	public static Object foldr(Functor function, Iterable<Object> obj) {
		return foldr(function, ArrayTools.toArray((Collection<Object>) obj));
	}

	public static Object foldl(Functor function, Iterable<Object> obj) {
		return foldl(function, ArrayTools.toArray(obj));
	}
}
