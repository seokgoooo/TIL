
public class Test {
	public static void main(String[] args) {
		int temp = 6;
		while (temp / 2 != 1) {
			int a = temp % 2;
			temp /= 2;
			System.out.println(a);
		}
	}
}
