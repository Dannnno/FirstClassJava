/**
 * 
 */
package hof;

/**
 * @author Dan
 * 
 */
public class StringBuilders {

	public static StringBuilder appendTo(StringBuilder sb,
			Iterable<String> parts) {
		for (String s : parts) {
			sb.append(s);
		}
		return sb;
	}

	public static StringBuilder appendTo(StringBuilder sb, String[] parts) {
		for (String s : parts) {
			sb.append(s);
		}
		return sb;
	}

	public static StringBuilder appendTo(StringBuilder sb, String first,
			String second, String... rest) {
		sb.append(first);
		sb.append(second);
		for (String s : rest) {
			sb.append(s);
		}
		return sb;
	}

}
