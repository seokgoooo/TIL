import first.InPackageClass;
import first.second.AnotherClass;

// package

public class Main {
	public static void main(String[] args) {
		InPackageClass test = new InPackageClass();
		
		AnotherClass test2 = new AnotherClass();
		
		test2.number = 10;
//		test2.mySecret = 22;
//		test.test = 33;
	}
}