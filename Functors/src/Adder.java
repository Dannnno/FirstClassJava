public class Adder extends HigherOrderFunctions.Functor {
	
		public Object run(Object...objects) {
		return (Integer) objects[0] + new Integer(1);
	}
	
	public static void main() {
		System.out.println(HigherOrderFunctions.map(new Adder(), new Integer[4]));
	}
}