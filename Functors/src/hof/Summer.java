/**
 * 
 */
package hof;

/**
 * @author Dan
 *
 */
public class Summer extends Functor{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] test = {1, 2, 3, 4};
		System.out.println(Reduce.foldr(new Summer(), test));
		System.out.println(Reduce.foldr(new Summer(), 0, test));
		System.out.println(Reduce.foldl(new Summer(), test));
		System.out.println(Reduce.foldl(new Summer(), 0, test));

	}

	@Override
	Object run(Object... args) {
		return (Integer) args[0] + (Integer) args[1];
	}

}
