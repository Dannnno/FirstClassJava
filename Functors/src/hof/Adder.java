package hof;

import java.util.Arrays;


public class Adder extends Functor {

	public Object run(Object... objects) {
		return (Integer) objects[0] + new Integer(1);
	}
	
	public static void main(String[] args) {
		Integer[] i = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(MapF.map(new Adder(), i)));
	}
}
