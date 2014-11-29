/**
 * 
 */
package hof;

/**
 * @author Dan
 * 
 */
public class Joiner {

	public Appendable<String> appender;
	public static StringBuilder appenderSB = new StringBuilder();
	public String separator;
	private Boolean skipNulls = false;
	private String nullText;

	public Joiner(char separator) {
		this(Character.toString(separator));
	}

	public Joiner(String separator) {
		this.separator = separator;
	}

	public Joiner(String separator, Boolean nulls) {
		this(separator);
		this.skipNulls = nulls;
	}

	public Joiner(String separator, String nullText) {
		this(separator);
		this.nullText = nullText;
	}

	public String join(Iterable<String> parts) {
		StringBuilder sb = new StringBuilder();
		for (String s : parts) {
			sb = StringBuilders.appendTo(sb, separator, s);
		}
		return sb.toString();
	}

	public String join(String[] parts) {
		StringBuilder sb = new StringBuilder();
		for (String s : parts) {
			sb = StringBuilders.appendTo(sb, separator, s);
		}
		return sb.toString();
	}

	public String join(String first, String second, String... rest) {
		StringBuilder sb = new StringBuilder();
		sb.append(separator + first);
		sb.append(separator + second);
		for (String s : rest) {
			sb = StringBuilders.appendTo(sb, separator, s);
		}
		return sb.toString();
	}

	public static Joiner on(char separator) {
		return new Joiner(separator);
	}

	public static Joiner on(String separator) {
		return new Joiner(separator);
	}

	public Joiner skipNulls() {
		return new Joiner(this.separator, true);
	}

	public Joiner useForNull(String nullText) {
		return new Joiner(this.separator, nullText);
	}
}
