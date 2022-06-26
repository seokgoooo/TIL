import java.util.Scanner;

public class Question {
	public static void main(String[] args) {
		// 1. 정수 2개의 연산자(문자열 + - * /) 등을 입력받아 사칙연산을 수행하는 계산기 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.print("+ - * / 중 에 하나 입력하시오: ");
		String symbol = scan.nextLine();

		System.out.print("정수 입력 하시오: ");
		int leftInt = scan.nextInt();
		System.out.print("정수 입력 하시오: ");
		int rightInt = scan.nextInt();
		if (symbol.equals("+")) {
			System.out.println("답은: " + (leftInt + rightInt));
		} else if (symbol.equals("-")) {
			System.out.println("답은: " + (leftInt - rightInt));
		} else if (symbol.equals("*")) {
			System.out.println("답은: " + (leftInt * rightInt));
		} else {
			System.out.println("답은: " + (leftInt / rightInt));
		}

		// 2. 정수를 입력받아 짝수면 "짝수입니다" 출력 홀수면 "홀수입니다" 출력
		System.out.print("정수 입력하세요. ");
		int inputNumber = scan.nextInt();
		if (inputNumber % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}

		// 3. 정수를 입력받아 큰수에서 작은수로 나눈 몫과 나머지 출력
		System.out.print("정수 입력하세요. ");
		int firstNumber = scan.nextInt();
		int secondNumber = scan.nextInt();
		int division;
		int remainder;

		if (firstNumber != 0 && secondNumber != 0) {
			if (firstNumber > secondNumber) {
				division = firstNumber / secondNumber;
				remainder = firstNumber % secondNumber;
			} else {
				division = secondNumber / firstNumber;
				remainder = secondNumber % firstNumber;
			}
			// 이렇게 하면 한 번에 수정 가능하다
			System.out.println("몫: " + division);
			System.out.println("나머지: " + remainder);
		} else {
			System.out.println("0을 입력하지마세요");
		}

		// 4. 정수를 입력받아 60점 이상이면 합격 아니면 불합격 출력과 함께 부족한 점수도 같이 출력
		System.out.print("점수 입력하세요. ");
		int scoreSixty = scan.nextInt();
		if (scoreSixty >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
			System.out.printf("부족한 점수: %d", 60 - scoreSixty);
		}

		// 5. 사용자의 나이와 이름을 입력받아서 입력값이 본인과 같으면 true, 아니면 false
		System.out.print("나이를 입력하세요: ");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.print("이름을 입력하세요: ");
		String name = scan.nextLine();
		System.out.println(age == 1 && name.equals("이름"));

		// 6. 컵 사이즈 알려주기 입력받아서 200이상이면 라지 100-200이면 미디움 100미만이면 small
		int cupSize = scan.nextInt();
		String sizeString;
		if (cupSize >= 200) {
			sizeString = "large";
		} else if (cupSize >= 100) {
			sizeString = "medium";
		} else {
			sizeString = "small";
		}
		System.out.println("컵사이즈는 " + sizeString);

		// 7. 오늘의 날씨를 물어보고 '비'를 입력받으면 우산을 챙겨가라고 문자를 출력하는 프로그램
		System.out.print("오늘의 날씨? ");
		String weather = scan.nextLine();
		if (weather.equals("비")) {
			System.out.println("우산을 챙겨가세요.");
		}
		System.out.println("좋은 하루 보내세요.");

		// 8. 3개의 정수를 입력받아 가장 큰 수를 출력
		System.out.print("정수 입력하세요. ");
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();
		int number3 = scan.nextInt();
		int max;
		if (number1 > number2 && number1 > number3) {
			max = number1;
		} else if (number2 > number1 && number2 > number3) {
			max = number2;
		} else {
			max = number3;
		}
		System.out.println("가장 큰수는 : " + max);

		// 9. 점수 입력받아 90점 이상 A 80점 이상 B 70점 이상 C 60점 이상 D 60미만 F
		int scoreIfElse = scan.nextInt();
		String englishScore;
		if (scoreIfElse >= 90) {
			englishScore = "A";
		} else if (scoreIfElse >= 80) {
			englishScore = "B";
		} else if (scoreIfElse >= 70) {
			englishScore = "C";
		} else if (scoreIfElse >= 60) {
			englishScore = "D";
		} else {
			englishScore = "F";
		}
		System.out.println("학점은 " + englishScore);
	}
}