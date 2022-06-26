import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		// 1. 사용자가 먼저 정해서 입력한 n개의 정수의 합과 평균
		Scanner scan = new Scanner(System.in);
		// 입력
		System.out.println("n개의 정수 입력.");
		int inputCountInt = scan.nextInt();
		int inputIntSum = 0;
		for (int i = 0; i < inputCountInt; i++) {
			// 연산
			inputIntSum += scan.nextInt();
		}
		// 출력
		System.out.println("합: " + inputIntSum);
		System.out.println("평균: " + inputIntSum / inputCountInt);

		// 2. 사용자가 먼저 정해서 입력한 n개의 정수의 합과 평균
		// 짝수 홀수 구분해서

		// 입력
		System.out.println("n개의 정수 입력.");
		int inputCountInt2 = scan.nextInt();
		int sumTotal = 0;
		int sumOdd = 0;
		int sumEven = 0;
		int countOdd = 0;
		int countEven = 0;
		for (int i = 0; i < inputCountInt2; i++) {
			// 연산
			sumTotal = scan.nextInt();
			if (sumTotal % 2 == 0) {
				sumEven += sumTotal;
				countEven++;
			} else {
				sumOdd += sumTotal;
				countOdd++;
			}
		}
		// 출력
		System.out.println("홀수 합: " + sumOdd);
		System.out.println("홀수 평균: " + sumOdd / countOdd);
		System.out.println("짝수 합: " + sumEven);
		System.out.println("짝수 평균: " + sumEven / countEven);

		// 3. 사용자가 정수 범위를 지정 (시작-끝 입력) - 합
		int startNumber = scan.nextInt();
		int endNumber = scan.nextInt();

		int sumRange = 0;
		for (int i = startNumber; i <= endNumber; i++) {
			sumRange += i;
		}
		System.out.printf("%d부터 %d까지의 합 = %d\n", startNumber, endNumber, sumRange);

		// 4. 사용자가 입력한 5개의 정수의 합
		// 입력
		System.out.println("5개의 정수 입력.");
		int sumFiveInt = 0;
		for (int i = 0; i < 5; i++) {
			int numFiveInt = scan.nextInt();
			// 연산
			sumFiveInt += numFiveInt;
		}
		// 출력
		System.out.println(sumFiveInt);

		// 5. 0부터 원하는 숫자까지 출력
		int printInt = scan.nextInt();
		int zeroInt = 0;

		while (zeroInt < printInt) {
			System.out.println(zeroInt);
			zeroInt++;
		}

		// 6. 최대 공약수
		int x, y, r;
		x = scan.nextInt();
		y = scan.nextInt();

		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		System.out.printf("최대 공약수는 %d입니다.\n", x);

		// 7. 구구단 4단
		// Scanner sc = new Scanner(System.in);
		// int i = 1;

		// while (i <= 9) {
		// System.out.println(4 + " * " + i + " = " + (4 * i));
		// i++;

		int gugudan = scan.nextInt();
		int gugudanSecond = 1;

		while (gugudanSecond <= 9) {
			System.out.println(gugudan + " * " + gugudanSecond + " = " + (gugudan * gugudanSecond));
			gugudanSecond++;
		}
	}
}