// TODO: Figure out how to do something like "asList" instead of "toArray"
// way to convert primitive types to their class equivalents
// ideally in a single method, not likely though...
// primitive types: byte, short, int, long, float, double, boolean, char

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.lang.Class;
//import java.lang.reflect.Method;
//import java.lang.reflect.Field;

public class HigherOrderFunctions {

	interface Callable {
		abstract Object run(Object... objs);
	}
	
	abstract static class Functor {
		abstract Object run(Object... objs);
	}
	
	private static Object[] iterableAsArray(Iterable<Object> obj) {
		ArrayList<Object> tempArrayList = new ArrayList<Object>();
		for(Object next: obj) {
			tempArrayList.add(next);
		}
		return tempArrayList.toArray();
	}
	
//	private static Class getIterableClass(Iterable<Object> obj) {
//		Class classOf = obj.getClass();
//		System.out.println(classOf);
//		return classOf;
//	}
//	
//	private static Iterable<Object> castIterable(Iterable<Object> obj, Class clazz) {
//		if(obj.getClass().equals(clazz)) {
//			return obj;
//		} else {
//			try {
//				Object iter = clazz.newInstance();
//				(Iterable<Object>) iter;
//	        } catch (ClassNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (NoSuchMethodException nsme){
//	            nsme.printStackTrace();
//	        } catch (IllegalAccessException iae) {
//	            iae.printStackTrace();
//	        } catch (InstantiationException ie) {
//	            ie.printStackTrace();
//	        } 
//	    }
//			return new ArrayList<Object>();
//		}
//	}

	public static Object[] map(Functor function, Object[] obj) {
		Object[] newList = new Object[obj.length];
		for (int i = 0; i < obj.length; i++) {
			newList[i] = function.run(obj[i]);
		}
		return newList;
	}
	
	public static Iterable<Object> map(Functor function, Iterable<Object> obj) {
		Object[] asArray = iterableAsArray(obj);
		return Arrays.asList(map(function, asArray));
	}

	public static Object[] filter(Functor function, Object[] obj) {
		ArrayList<Object> filteredList = new ArrayList<Object>();
		for (int i = 0; i < obj.length; i++) {
			if ((Boolean) function.run(obj[i])) {
				filteredList.add(obj[i]);
			}
		}
		return filteredList.toArray();
	}
	
	public static Iterable<Object> filter(Functor function, Iterable<Object> obj) {
		Object[] asArray = iterableAsArray(obj);
		return Arrays.asList(filter(function, asArray));
	}

	public static Object foldr(Functor function, Object startingPoint,
			Object[] obj) {
		Object result = startingPoint;
		for (int i = obj.length - 1; i >= 0; i--) {
			result = function.run(result, obj[i]);
		}
		return result;
	}
	
	public static Object foldr(Functor function, Object startingPoint, Iterable<Object> obj) {
		Object[] asArray = iterableAsArray(obj);
		return foldr(function, startingPoint, asArray);
	}

	public static Object foldl(Functor function, Object startingPoint,
			Object[] obj) {
		Object result = startingPoint;
		for (int i = 0; i < obj.length; i++) {
			result = function.run(result, obj[i]);
		}
		return result;
	}
	
	public static Object foldl(Functor function, Object startingPoint, Iterable<Object> obj) {
		Object[] asArray = iterableAsArray(obj);
		return foldl(function, startingPoint, asArray);
	}
	
	public static Object foldr(Functor function, Object[] obj) {
		Object startingPoint = obj[obj.length-1];
		List<Object> asList = Arrays.asList(obj);
		List<Object> subList = asList.subList(0, obj.length-2);
		return foldr(function, startingPoint, subList.toArray());		
	}
	
	public static Object foldr(Functor function, Iterable<Object> obj) {
		return foldr(function, iterableAsArray(obj));
	}
	
	public static Object foldl(Functor function, Object[] obj) {
		Object startingPoint = obj[0];
		List<Object> asList = Arrays.asList(obj);
		List<Object> subList = asList.subList(1, obj.length-1);
		return foldl(function, startingPoint, subList.toArray());		
	}
	
	public static Object foldl(Functor function, Iterable<Object> obj) {
		return foldl(function, iterableAsArray(obj));
	}
}
