package learnInterface;

public class Main implements MyInterface {
	public static void main(String[] args) {
		System.out.println(Days.NUM);
//		Days.num = 100;
		
		Main m = new Main();
		m.printHello();
		
		MyInterface.myStaticMethod();
		System.out.println(MyInterface.sum(3, 5));
		
	}
}