/* Exception 은 크게 2가지
1. RuntimeException : 실행시 발생하는 예외
2. Exception : 컴파일시 발생하는 예외
즉, Exception은 프로그램 작성시 이미 예측가능한 예외를 작성할 때 사용하고 RuntimeException은 발생 할수도 발생 안 할수도 있는 경우에 작성한다.
그래서 Exception을 Checked Exception, RuntimeException을 Unchecked Exception 이라고도 한다.
*/

import java.util.Scanner;

public class Main5 {
	public static int divide(int left, int right) throws MyZeroDivideException { // , Exception throws 클래스, 클래스, , , , 등등 , 로 여러개 가능
		if (right == 0) {
			throw new MyZeroDivideException("나눌 수 없음");
		} else
			return left / right;
	}

	public static int myFunction() {
		// 아직 미완성
		throw new UnsupportedOperationException("내일 만들게");
	}

	public static void main(String[] args) {
//		int result = divide(100, 50);	// checkedException 발생 시 무조건 try catch로 잡아줘야한다 (아니면 RuntimeException을 상속 받아도 된다)
//		
//		Scanner scan = new Scanner(System.in);
//		
//		scan.nextInt();
		
		myFunction();
	}
}