public class Swap {
	public static void main(String[] args) {
		int a = 10;
		int b = 55;
		int c = a;
		
		a = b;
		b = c;
		
		System.out.println(a);
		System.out.println(b);
	}
}