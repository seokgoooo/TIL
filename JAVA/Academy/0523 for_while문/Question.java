import java.util.Scanner;

public class Question {
	public static void main(String[] args) {
		// 1. 2의 제곱수를 32개 나열하고 결과값을 확인해보세요
		// 2 4 8 16 32 ...
		long resultFirst = 1;
		for (int i = 1; i < 32; i++) {
			resultFirst *= 2;
			System.out.println(resultFirst);
		}

		// 2. 사용자의 입력 n, m 출력 : n의 m제곱
		Scanner scan = new Scanner(System.in);
		int n, m;
		n = scan.nextInt();
		m = scan.nextInt();

		long resultSecond = n;
		for (int i = 0; i < (m - 1); i++) {
			resultSecond *= n;
		}
		System.out.println(resultSecond);

		// 3. 자판기 프로그램 입력 : 돈 반복하여 입력을 받아
		// 1번 콜라 : 1500
		// 2번 사이다 : 1300
		// 3번 계산
		// 총 몇 개의 캔을 구입하고 거스름돈은 얼마인지 출력
		System.out.print("돈 입력: ");
		int inputMoney = scan.nextInt();
		int coke = 0;
		int soda = 0;

		while (inputMoney > 0) {
			System.out.println("*** 1번 콜라 1500원 *** 2번 사이다 1300원 *** 3번 계산 ***");
			System.out.println("1, 2, 3 중에 고르세요");
			int choose = scan.nextInt();
			if (choose == 1) {
				if (inputMoney >= 1500) {
					inputMoney -= 1500;
					coke++;
					System.out.println("콜라: " + coke + "캔");
					System.out.println("사이다: " + soda + "캔");
					System.out.println("남은 돈: " + inputMoney);
				} else {
					System.out.println("남은 돈: " + inputMoney);
					System.out.println("잔액이 부족합니다.");
					inputMoney = -1;
				}
			} else if (choose == 2) {
				if (inputMoney >= 1300) {
					inputMoney -= 1300;
					soda++;
					System.out.println("콜라: " + coke + "캔");
					System.out.println("사이다: " + soda + "캔");
					System.out.println("남은 돈: " + inputMoney);
				} else {
					System.out.println("남은 돈: " + inputMoney);
					System.out.println("잔액이 부족합니다.");
					inputMoney = -1;
				}
			} else if (choose == 3) {
				System.out.println("콜라: " + coke + "캔");
				System.out.println("사이다: " + soda + "캔");
				System.out.println("거스름돈: " + inputMoney);
				inputMoney = -1;
			}
		}

		// 4. 입력 : 정수 / 출력 : 짝수 나열하고 총 개수
		System.out.print("몇가지의 정수인가요?: ");
		int totalNumberCount = scan.nextInt();
		int evenCount = 0;

		for (int i = 0; i < totalNumberCount; i++) {
			System.out.println(totalNumberCount + "개의 정수 입력");
			int inputInt = scan.nextInt();
			if (inputInt % 2 == 0) {
				System.out.println("짝수: " + inputInt);
				evenCount++;
			}
		}
		System.out.println("짝수 총 개수: " + evenCount);

		// 5. 입력 : 5개의 정수 / 출력 : 가장 큰 수
		int[] numFive = new int[5];
		int numMax = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("5개의 정수 입력: ");
			numFive[i] = scan.nextInt();
			if (numFive[numMax] < numFive[i]) {
				numMax = i;
			}
		}
		System.out.println("가장 큰 수: " + numFive[numMax]);

		// 6. 입력 : 영단어(latin 문자열)에서 / 출력 : 모음(a e i o u)이 몇 개인지
		int vowelCount = 0;
		System.out.print("영어 입력: ");
		String latin = scan.nextLine();

		for (int i = 0; i < latin.length(); i++) {
			if (latin.charAt(i) == 'a' || latin.charAt(i) == 'e' || latin.charAt(i) == 'i' || latin.charAt(i) == 'o'
					|| latin.charAt(i) == 'u') {
				vowelCount++;
			}
		}
		System.out.println("모음의 수: " + vowelCount);
	}
}