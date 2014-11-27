package hof;
import java.util.ArrayList;
import java.util.Arrays;

public class HigherOrderFunctions {

	public static Object[] iterableAsArray(Iterable<Object> obj) {
		ArrayList<Object> tempArrayList = new ArrayList<Object>();
		for (Object next : obj) {
			tempArrayList.add(next);
		}
		return tempArrayList.toArray();
	}

	public static void printArray(Object[] obj) {
		System.out.println(Arrays.toString(obj));
	}
}
