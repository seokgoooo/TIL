package learnInterface;

public interface Days {
//	interface 용도 +
// 	상수 정의 해놓고 사용 가능
	int NUM = 10;
//	이거랑 같은 말
//	public static final int NUM = 10;
	
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WENDSDAY = 3;
}

interface MyInterface {
	// default 메소드는 interface에서 미리 구현이 가능하다
	default void printHello() {
		System.out.println("Hello");
	}
	
	public static void myStaticMethod() {
		System.out.println("Static");
	}
	
//	private 한 메소드는 안 된다 (자바 9버전 이상 부터는 가능)
//	private static int sum(int a, int b) {
//		return a + b;
//	}
	
	static int sum(int a, int b) {
		return a + b;
	}
}