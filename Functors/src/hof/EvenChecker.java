package hof;
/**
 * 
 */

/**
 * @author Dan
 * 
 */
public class EvenChecker extends Functor {

	public static class EvenChecker2 extends Functor {
		Object run(Object... args) {
			return ((Integer) args[0]) % 2 == 0 && ((Integer) args[1]) % 2 == 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] i = { 1, 2, 3, 4 };
		HigherOrderFunctions.printArray(Filter.filter(new EvenChecker(), i));

	}

	@Override
	Object run(Object... args) {
		return ((Integer) args[0]) % 2 == 0;
	}

}
