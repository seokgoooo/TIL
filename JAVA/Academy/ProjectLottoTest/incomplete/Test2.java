import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test2 {
	private Set<Integer> numbers = new HashSet<Integer>();

	public Test2() {
		numbers.add(2);
	}

	@Override
	public String toString() {
		return numbers + " ";
	}

	public static void main(String[] args) {
		Test2 a = new Test2();
		System.out.println(a);

		Iterator<Test2> print = new Iterator<Test2>() {

		};
		for (Int b : a) {
			System.out.println(b);
		}
	}
}