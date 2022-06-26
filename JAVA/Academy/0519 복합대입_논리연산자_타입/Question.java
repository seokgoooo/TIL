import java.util.Scanner;

public class Question {
	public static void main(String[] args) {
// 1. 입력 : 정수가 0이상이며 7의 배수 일때 출력 : true
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하시오: ");
		int numberSeven = scan.nextInt();
		// boolean result = (number >= 0) && (number % 7 == 0);
		System.out.println("0이상이며 7의 배수인가? " + ((numberSeven >= 0) && (numberSeven % 7 == 0)));

//2. 사용자에게 3개의 정수를 입력받아 순서대로 입력된 수일 경우 true을 출력하세요. 나머지 경우는 false
//예) 1 2 3 -> true,4 5 6 -> true,7 9 10 -> false
		System.out.print("3개의 정수를 차례대로 입력하시오: ");
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();
		int number3 = scan.nextInt();
		// boolean result = (number2 - 1 == number1) && (number2 + 1 == number3);
		System.out.println("순서대로 입력된 수인가? " + ((number2 - 1 == number1) && (number2 + 1 == number3)));

//3. 사용자가 입력한 4자리의 정수가 좌우가 같을 때 true를 출력하세요. 나머지 경우는 false
//예) 1221 -> true,1557 -> false,9009 -> true
		System.out.print("4자리의 정수를 입력하시오: ");
		int numberLeftRight = scan.nextInt();
		// boolean result = (number % 10) == (number / 1000);
		System.out.println("좌우가 같은 수인가? " + ((numberLeftRight % 10) == (numberLeftRight / 1000)));
	}
}
// 오늘한 것
// 기본형(원시형) 데이터 타입
// 정수형, 실수형, 논리형, 문자형

// 변수 두 개의 값 교환
// 복합대입연산자
// 증감연산자
// 관계연산자
// 논리연산자