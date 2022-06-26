// 한줄 주석
/* 범위 주석 */

public class Hello { // Hello 클래스(class)
	public static void main(String[] args) { // 메인 메소드 (method) - 작성한 프로그램의 시작점
		System.out.println("Hello world!");
		System.out.println("884840-1581808");
		System.out.println("1840845845");

		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);

		System.out.println(10 + "10");
		System.out.println("10" + 10);
		System.out.println();
		System.out.println(0.123);
		System.out.println(0.123 + 0.1);

		System.out.print(1);
		System.out.print(2);
		System.out.print(3);

//		System.out.println("ABC" - 5);
		System.out.println(50 / 0);
		System.out.println("10 곱하기 5는 : " + 10 * 5);
		System.out.println("22 나누기 4는 : " + 22 / 4);
		System.out.println("22 나누기 4는 : " + 22.0 / 4.0);
		System.out.println("프로그램 정상 종료");

		int x;
		int y;
		int sum;

		x = 100; // = : 대입연산자
		y = 200;
		sum = x + y;

		System.out.println(sum);
		System.out.println(x - y);

		int minus;
		minus = x - y;
		System.out.println(minus);

		int a = 44;
		int b = 72;
		int sumAb = a + b;
		int minusAb = a - b;
		int mul = a * b;
		int div = a / b;

		System.out.println("44 + 72 : " + sumAb);
		System.out.println("44 - 72 : " + minusAb);
		System.out.println("44 X 72 : " + mul);
		System.out.println("44 / 72 : " + div);
	}
}