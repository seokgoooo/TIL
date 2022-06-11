// 입력한 두 정수의 합 출력, 합이 0이면 true 출력 아니면 false
import java.util.Scanner;

public class ZeroTnf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하시오: ");
		int a = input.nextInt();
		System.out.print("두 번째 정수를 입력하시오: ");
		int b = input.nextInt();
		
		int sum = a + b;		
		System.out.println("정수의 합: " + sum);
		
		boolean result = (sum == 0);
		System.out.println("합이 0인가? " + result);
	}
}