public class Adder extends HigherOrderFunctions.Functor {

	public Object run(Object... objects) {
		return (Integer) objects[0] + new Integer(1);
	}
	
	public static void printArray(Object[] array) {
		String a = "{ ";
		for(Object o: array) {
			a += o.toString() + ", ";
		}
		a = a.substring(0, a.length()-2);
		a += " }";
		System.out.println(a);
	}

	public static void main(String[] args) {
		Integer[] i = { 1, 2, 3, 4 };
		printArray(HigherOrderFunctions.map(new Adder(), i));
	}
}
