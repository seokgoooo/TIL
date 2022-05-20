public class TestString2 {
	public static void main(String[] args) {
		String hello = "Hello";

		char h = hello.charAt(0);
		System.out.println(h);
		// System.out.println(hello.charAt(-1));
		System.out.println(hello.charAt(1));
		System.out.println(hello.charAt(2));
		System.out.println(hello.charAt(3));
		System.out.println(hello.charAt(4));
		
		int length = hello.length();
		System.out.println(length);
	}
}