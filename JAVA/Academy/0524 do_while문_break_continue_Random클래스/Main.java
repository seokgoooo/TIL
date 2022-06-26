import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 1. Do-While
		// while (false) {
		// 문장1
		// }
		Scanner scan = new Scanner(System.in);
		System.out.println("10을 나눌 수 입력하세요");
		int numberDoWhile;
		do {
			numberDoWhile = scan.nextInt();
			if (numberDoWhile == 0) {
				System.out.println("0으로 나눌 수 없음");
			}
		} while (numberDoWhile == 0);
		System.out.println(10 / numberDoWhile);

		// do {
		// System.out.println("실행 되나?");
		// } while (false);

		// 2. Continue
		String strContinue = "no news is good news";
		int countN = 0;
		for (int i = 0; i < strContinue.length(); i++) {
			// n이 나오는 횟수를 센다
			if (strContinue.charAt(i) != 'n')
				continue;
			// n의 개수를 하나 증가한다.
			countN++;
		}
		System.out.println("문장에서 발견된 n의 개수 " + countN);

		// 3. break
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		for (int i = 10; i < 20; i++) {
			if (i % 10 == 5) {
				continue;
			}
			System.out.println(i);
		}

		int j = 20;
		while (j < 30) {
			// if (i == 25) {
			// continue;
			// }
			if (j != 25) {
				System.out.println(j);
			}
			j++;
		}
		System.out.println("프로그램 종료.");

		// 4. LetterGame
		Random random = new Random();
		int answer = random.nextInt(100);
		int guess;
		int tries = 0;

		do {
			System.out.print("정답을 추측하여 보시오: ");
			guess = scan.nextInt();
			tries++;
			if (guess > answer) {
				System.out.println("제시한 정수가 높습니다.");
			}
			if (guess < answer) {
				System.out.println("제시한 정수가 낮습니다.");
			}
		} while (guess != answer);
		System.out.printf("축하합니다. 시도 횟수=%d \n", tries);

		// 5. Average
		int totalScore = 0;
		int countScore = 0;
		while (true) {
			System.out.print("점수를 입력하시오: ");
			int inputScore = scan.nextInt();
			if (inputScore < 0) {
				break;
			}
			totalScore += inputScore;
			countScore++;
		}
		System.out.println("평균은 " + totalScore / countScore);

		// 6. 팩토리얼
		long factorial = 1;
		int factorialInt;
		System.out.printf("정수를 입력하시오: ");
		factorialInt = scan.nextInt();
		for (int i = 1; i <= factorialInt; i++) {
			factorial = factorial * i;
		}
		System.out.printf("%d!은 %d입니다. \n", factorialInt, factorial);
	}
}