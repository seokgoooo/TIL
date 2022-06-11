// 2. 사용자에게 3개의 정수를 입력받아 순서대로 입력된 수일 경우 true을 출력하세요. 나머지 경우는 false
// 예) 1 2 3 -> true,4 5 6 -> true,7 9 10 -> false
import java.util.Scanner;

public class QuestionTwo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("3개의 정수를 차례대로 입력하시오: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
				
		// boolean result = (number2 - 1 == number1) && (number2 + 1 == number3);
		
		System.out.println("순서대로 입력된 수인가? " + ((number2 - 1 == number1) && (number2 + 1 == number3)));
	}
}