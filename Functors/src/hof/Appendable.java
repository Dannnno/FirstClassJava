package hof;

import java.util.Iterator;
import java.util.Collection;

public abstract class Appendable<T> implements Iterable<T> {

	public Collection<T> list;

	public Iterator<T> iterator() {
		return this.list.iterator();
	}

	public abstract void append(Object o);

	public void appendTo(Iterable<Object> parts) {
		for (Object o : parts) {
			this.append(o);
		}
	}

	public void appendTo(Object[] parts) {
		for (Object o : parts) {
			this.append(o);
		}
	}

	public void appendTo(Object first, Object second, Object... rest) {
		this.append(first);
		this.append(second);
		for (Object o : rest) {
			this.append(o);
		}
	}

}
