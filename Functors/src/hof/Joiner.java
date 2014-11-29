/**
 * 
 */
package hof;

/**
 * @author Dan
 * 
 */
public class Joiner<T> {

	public Appendable<T> appender;
	public T separator;
	private T nullReplacement;
	private Boolean skipNulls = false;
	private Boolean replaceNulls = false;

	public Joiner(T separator, Appendable<T> app) {
		this.separator = separator;
		this.appender = app;
	}

	public Joiner(T separator, Appendable<T> app, T nullReplacer) {
		this(separator, app);
		this.nullReplacement = nullReplacer;
		this.replaceNulls = true;
	}

	public Joiner(T separator, Appendable<T> app, Boolean nullSkip) {
		this(separator, app);
		this.skipNulls = nullSkip;
	}

	@SuppressWarnings("unchecked")
	public void join(Iterable<T> parts) throws NullPointerException {
		if (skipNulls) {
			for (T s : parts) {
				if (!(s == null)) {
					appender.appendTo(separator, s);
				} else if (this.replaceNulls) {
					appender.appendTo(separator, this.nullReplacement);
				}
			}
		} else {
			this.join(parts, false);
		}
	}

	@SuppressWarnings("unchecked")
	private void join(Iterable<T> parts, Boolean nulls)
			throws NullPointerException {
		for (T s : parts) {
			if (!(s == null)) {
				appender.appendTo(separator, s);
			} else {
				throw new NullPointerException();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void join(T[] parts) throws NullPointerException {
		if (skipNulls) {
			for (T s : parts) {
				if (!(s == null)) {
					appender.appendTo(separator, s);
				} else if (this.replaceNulls) {
					appender.appendTo(separator, this.nullReplacement);
				}
			}

		} else {
			this.join(parts, false);
		}
	}

	@SuppressWarnings("unchecked")
	private void join(T[] parts, Boolean nulls) throws NullPointerException {
		for (T s : parts) {
			if (!(s == null)) {
				appender.appendTo(separator, s);
			} else {
				throw new NullPointerException();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void join(T first, T second, T... rest) throws NullPointerException {
		if (skipNulls) {
			if (!(first == null)) {
				appender.appendTo(separator, first);
			} else if (this.replaceNulls) {
				appender.appendTo(separator, this.nullReplacement);
			}
			if (!(second == null)) {
				appender.appendTo(separator, second);
			} else if (this.replaceNulls) {
				appender.appendTo(separator, this.nullReplacement);
			}
			for (T s : rest) {
				if (!(s == null)) {
					appender.appendTo(separator, s);
				} else if (this.replaceNulls) {
					appender.appendTo(separator, this.nullReplacement);
				}
			}

		} else {
			this.join(false, first, second, rest);
		}
	}

	@SuppressWarnings("unchecked")
	private void join(Boolean nulls, T first, T second, T... rest)
			throws NullPointerException {
		for (T s : rest) {
			if (!(s == null)) {
				appender.appendTo(separator, s);
			} else {
				throw new NullPointerException();
			}
		}

	}

	public static Joiner<Object> on(Object separator,
			Appendable<Object> appender) {
		return new Joiner<Object>(separator, appender);
	}

	public Joiner<Object> skipNulls(Appendable<Object> appender) {
		return new Joiner<Object>(this.separator, appender, true);
	}

	public Joiner<Object> useForNull(Appendable<Object> appender,
			Object nullText) {
		return new Joiner<Object>(this.separator, appender, nullText);
	}
}
