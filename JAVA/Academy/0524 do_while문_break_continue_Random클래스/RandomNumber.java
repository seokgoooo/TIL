// 0 ~ 9까지의 무작위 수를 정하여
// 사용자가 해당하는 수의 배수를 순서대로 입력하게 하여
// 틀릴 경우 종료
// 랜덤 수가 6일 경우
// 사용자 입력
// 6	0
// 12	0
// 18	0
// 21	X 종료

import java.util.Scanner;
import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int answer;
		int i = 1;
		int num = random.nextInt(8);
		int numberChange = num + 2;
		System.out.println(numberChange + "의 배수를 순서대로 입력하세요: ");

		while (true) {
			System.out.println("");
			answer = scan.nextInt();
			if (answer != (i * numberChange)) {
				System.out.print(answer + ": X");
				System.out.println("프로그램 종료");
				break;
			}
			if (answer == (i * numberChange)) {
				System.out.print(answer + ": O");
			}
			i++;
		}

		// for (int i = 1; i < 10; i++) {
		// System.out.println("");
		// answer = sc.nextInt();

		// if (answer != (i * numchange)) {
		// System.out.print(answer + ": X");
		// System.out.println("프로그램 종료");
		// }
		// if (answer == (i * numchange)) {
		// System.out.print(answer + ": O");
		// }
		// }
	}
}