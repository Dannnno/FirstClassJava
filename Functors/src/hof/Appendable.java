package hof;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collection;

public abstract class Appendable<T> implements Iterable<T> {

	public Collection<T> list = new ArrayList<T>();

	public Iterator<T> iterator() {
		try {
			return this.list.iterator();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			return null;
		}
	}

	public abstract void append(T o);

	public void appendTo(Iterable<T> parts) {
		for (T o : parts) {
			this.append(o);
		}
	}

	public void appendTo(T[] parts) {
		for (T o : parts) {
			this.append(o);
		}
	}

	public void appendTo(T first, T second, T... rest) {
		this.append(first);
		this.append(second);
		for (T o : rest) {
			this.append(o);
		}
	}

	@Override
	public String toString() {
		try {
			return this.list.toString();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			return null;
		}
	}

//	public String stringRepresentation() {
//		Class<T> c = T.getClass();
//		if (T instanceof String) {
//
//		}
//	}

	@SuppressWarnings("unchecked")
	public Class<T> getType() {
		Field listField = null;
		boolean success = false;
		try {
			listField = Appendable.class.getDeclaredField("list");
			success = true;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		if (success) {
			System.out.println(listField);
			ParameterizedType listFieldType = (ParameterizedType) listField
					.getGenericType();
			System.out.println(listFieldType);
			System.out.println(Arrays.toString(listFieldType.getActualTypeArguments()));
			System.out.println(listFieldType.getActualTypeArguments()[0]);
			System.out.println(listFieldType.getActualTypeArguments()[0].getClass());
			Class<?> listFieldClass = (Class<?>) listFieldType
					.getActualTypeArguments()[0];
			System.out.println(listFieldClass);
			return (Class<T>) listFieldClass;
		} else {
			return null;
		}
	}

}
