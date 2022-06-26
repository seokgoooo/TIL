public class Main {
	public static void main(String[] args) {
		boolean con = true;
		// 한 문장일 경우 {}가 없어도 된다.
		// if(con)
		// System.out.println("참일 경우 실행할 문장");
		// else
		// System.out.println("거짓일 경우 실행할 문장");

		// ? 삼항연산자
		String resultLine = (con) ? "참" : "거짓";
		System.out.println(resultLine);
		System.out.println("프로그램 종료");

		// Hello World 10번 출력하기
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");

		// 1 ~ 10000까지 출력하세요
		int i = 0;
		while (i < 5) {
			System.out.println("반복됩니다.");
			i++;
		}

		// int i = 1;
		// while (i <= 10) {
		// System.out.println("반복됩니다.");
		// i++;
		// }

		// 20 ~ 29까지 출력하기
		// int i = 20;
		// while (i <= 29) {
		// System.out.println(i + "반복됩니다");
		// i++;
		// }

		// 10 ~ 0까지
		// int x = 10;
		// while (x >= 0) {
		// System.out.println(x + "반복됩니다");
		// x--;
		// }

		// 3의 배수를 출력해보세요
		// int y = 0;
		// while (y < 100) {
		// System.out.println(y);
		// y += 3;
		// }

		// ☆
		// ★
		// ☆
		// ★ 출력하기

		int star = 0;
		while (star <= 20) {
			if (star % 2 == 0) {
				System.out.println("☆");
			} else {
				System.out.println("★");
			}
			star++;
		}

		// 0부터 100사이의 수 중 3의 배수 또는 7의 배수를 출력해보세요
		// 3 6 7 9 12 ...
		// int x = 0;
		// while (x <= 100) {
		// if ((x % 3 == 0) || (x % 7 == 0)) {
		// System.out.println(x);
		// }
		// x++;
		// }

		// 0부터 100사이 수 중 일의 자리 수가 3, 6, 9 일때만 출력
		int intThree = 0;
		while (intThree <= 100) {
			if ((intThree % 10 == 3) || (intThree % 10 == 6) || (intThree % 10 == 9)) {
				System.out.println(intThree);
			}
			intThree++;
		}

		// 반복이라는 문자열 5번 출력하기
		for (int j = 0; j < 5; j++) {
			System.out.println("출력");
		}

		// // 기존 while 반복문
		// int k = 0;
		// while (k < 5) {
		// System.out.println("출력");
		// k++;
		// }

		// 0부터 10까지 출력
		// for(int u = 0; u <= 10; u++) {
		// System.out.println(u);
		// }

		// 21부터 30까지 3의 배수
		// for(int j = 21; j <= 30; j += 3) {
		// System.out.println(j);
		// }

		// 30에서 20까지 -1씩
		for (int j = 30; j >= 20; j--) {
			System.out.println(j);
		}

		// 10 ~ 99 사이의 정수
		// for (int i = 10; i <= 99; i++) {
		// System.out.println(i);
		// }

		// 10의 자리 수와 1의 자리 수의 합이 7인 수만 출력
		for (int j = 10; j <= 99; j++) {
			int left = j / 10;
			int right = j % 10;
			if (left + right == 7) {
				System.out.println(j);
			}
		}

		// 100 ~ 400 사이 정수 중
		// 13의 배수를 찾아 몇 개가 있는지 출력
		int count13 = 0;
		for (int j = 100; j <= 400; j++) {
			if (j % 13 == 0) {
				// 개수를 세야함
				System.out.println("확인: " + j);
				count13++;
			}
		}
		System.out.println(count13);

		// 0 ~ 100 범위의 정수의 합
		// int sum = 0;
		// for(int i = 0; i <= 100; i++) {
		// sum += i;
		// }
		// System.out.printf("0부터 100까지의 정수 합 = %d\n", sum);

		// 100 ~ 200 사이의 짝수의 합
		int sumEven100200 = 0;
		for (int j = 100; j <= 200; j += 2) {
			System.out.print(j);
			sumEven100200 += j;
		}
		System.out.printf("100부터 200까지의 짝수 합 = %d\n", sumEven100200);
	}
}