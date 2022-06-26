import java.util.Scanner;

public class AutoInc {
	public static void main(String[] args) {
		int a = 55;
		a = 78;
		// a = a + 5;
		a += 5;
		System.out.println(a);

		int plusTest = 10;
		// 복합 대입 연산자 += -= *= /=
		// a += 1;
		// a -= 1;

		// 증감연산자 -> 순서에 따라 값이 달라진다.
		// a++; -> a 이후 +1
		// ++a; -> +1 이후 a
		// 문장 위아래 순서를 통해서 사용해보자
		System.out.println(plusTest++);
		System.out.println(plusTest);

		// 입력값 -2 +2 범위의 정수를 출력해보세요
		// 예 7 -> 5 6 7 8 9
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하시오: ");
		int inputNumber = scan.nextInt();

		System.out.print(inputNumber -= 2);
		System.out.print(++inputNumber);
		System.out.print(++inputNumber);
		System.out.print(++inputNumber);
		System.out.print(++inputNumber);

		int x = 10;
		int y = 55;
		int z = x;
		x = y;
		y = z;
		System.out.println(x);
		System.out.println(y);

		// 관계연산자 : 물어보는 연산자
		System.out.println(55 == 55);
		System.out.println(55 != 55);
		System.out.println(55 > 55);
		System.out.println(55 < 55);
		System.out.println(55 >= 55);
		System.out.println(55 <= 55);

		// 0 ~ 100 사이?
		int number = 33;
		System.out.println(0 <= number && number <= 100);

		// 입력한 정수가 짝수면 true 홀수면 false
		System.out.print("정수를 입력하시오: ");
		int intTrueFalse = scan.nextInt();
		boolean result = (intTrueFalse % 2 == 0);
		System.out.println("짝수인가? " + result);

		// 입력한 두 정수의 합 출력, 합이 0이면 true 출력 아니면 false
		System.out.print("첫 번째 정수를 입력하시오: ");
		int firstNum = scan.nextInt();
		System.out.print("두 번째 정수를 입력하시오: ");
		int secondNum = scan.nextInt();
		int sumNum = firstNum + secondNum;
		System.out.println("정수의 합: " + sumNum);
		boolean resultBoolean = (sumNum == 0);
		System.out.println("합이 0인가? " + resultBoolean);

		// 입력 : 벤치, 스쿼트, 데드 -> 합이 500 이상이면 true, false
		System.out.print("벤치를 입력하시오: ");
		int bench = scan.nextInt();
		System.out.print("스쿼트를 입력하시오: ");
		int squat = scan.nextInt();
		System.out.print("데드를 입력하시오: ");
		int deadlift = scan.nextInt();
		boolean result500 = (bench + squat + deadlift) >= 500;
		System.out.println("입어도되나? " + result500);
	}
}