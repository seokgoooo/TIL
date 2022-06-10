public class Main {
	public static void someMethod(int param) {
		
	}
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void sum(double a, double b) {
		System.out.println(a + b);
	}
	
	public static void main(String[] args) {
//		someMethod(3873.03736);
//		someMethod("asdf");
		
		// Method Overloading
//		System.out.println(123123);
//		System.out.println(123.123);
//		System.out.println("123.123");
		sum(50, 20);
		sum(10.0, 40.0);
//		sum("asdf", "qwer");
	}
}
