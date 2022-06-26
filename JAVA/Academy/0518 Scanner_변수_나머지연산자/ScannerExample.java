import java.util.Scanner;

public class ScannerExample {
	public static void main(String args[]) {
		// 리터럴 상수 44 72
		int x = 44;
		int y = 72;

		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);

		System.out.println(27 / 4);
		System.out.println(27 % 4);

		System.out.println(0 % 2);
		System.out.println(1 % 2);
		System.out.println(2 % 2);
		System.out.println(3 % 2);
		System.out.println(4 % 2);

		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하시오: ");
		int firstNumber = scan.nextInt();
		System.out.print("두 번째 숫자를 입력하시오: ");
		int secondNumber = scan.nextInt();
		int sumNumber = firstNumber + secondNumber;
		System.out.println(sumNumber);

		// 사용자에게 정수 하나를 입력받아서 제곱값을 출력
		System.out.print("정수를 입력하시오: ");
		int number = scan.nextInt();
		System.out.printf("정수의 제곱값: " + (number * number));

		// 밑변과 높이를 정수로 입력 사각형의 둘레와 넓이를 출력
		// 둘레 : (밑변 + 높이) *2 . 넓이 (밑변 * 높이)
		System.out.print("밑변을 입력하시오: ");
		int lineBox = scan.nextInt();
		System.out.print("높이을 입력하시오: ");
		int heightBox = scan.nextInt();
		int roundBox = (lineBox + heightBox) * 2;
		int areaBox = lineBox * heightBox;
		System.out.println("사각형의 둘레 : " + roundBox);
		System.out.println("사각형의 넓이 : " + areaBox);

		// 원의 넓이
		System.out.print("반지름을 입력하시오: ");
		double radius = scan.nextDouble();
		double areaCircle = 3.14 * radius * radius;
		System.out.println(areaCircle);

		// 국어, 영어, 수학 점수를 정수로 입력받아 총합과 평균점수를 출력하는 프로그램
		System.out.print("국어 점수 입력: ");
		int korScore = scan.nextInt();
		System.out.print("영어 점수 입력: ");
		int engScore = scan.nextInt();
		System.out.print("수학 점수 입력: ");
		int mathScore = scan.nextInt();

		int sumScore = korScore + engScore + mathScore;
		int avgScore = sumScore / 3;
		System.out.println("점수 총합: " + sumScore);
		System.out.println("점수 평균: " + avgScore);

		// 초단위의 시간을 입력받아 시간 분 초로 변환을 하는 프로그램
		System.out.print("초를 입력: ");
		int secInput = scan.nextInt();
		int hour = (secInput / 3600);
		int min = (secInput % 3600 / 60);
		int secCal = (secInput % 60);
		System.out.print(hour + " 시간 " + min + " 분 " + secCal + " 초");

		// 5자리의 정수를 입력 받아 1자리씩 출력
		System.out.print("5자리의 정수를 입력하시오: ");
		int number10000 = scan.nextInt();
		int number5 = number10000 % 10;
		int number4 = (number10000 / 10) % 10;
		int number3 = (number10000 / 100) % 10;
		int number2 = (number10000 / 1000) % 10;
		int number1 = (number10000 / 10000);

		System.out.print(number5);
		System.out.print(number4);
		System.out.print(number3);
		System.out.print(number2);
		System.out.print(number1);
	}
}