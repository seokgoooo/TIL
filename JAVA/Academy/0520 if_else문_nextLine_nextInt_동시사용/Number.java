// 정수를 입력받아 짝수면 "짝수입니다" 출력 홀수면 "홀수입니다" 출력
import java.util.Scanner;

public class Number {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 입력하세요. ");
		int x = scanner.nextInt();
		
		if (x % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		else {
		System.out.println("홀수입니다.");
		}
	}
}