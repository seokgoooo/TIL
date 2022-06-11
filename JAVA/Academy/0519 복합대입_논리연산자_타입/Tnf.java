// 입력한 정수가 짝수면 true 홀수면 false
import java.util.Scanner;

public class Tnf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 입력하시오: ");
		int x = input.nextInt();
			
		boolean result = (x % 2 == 0);
		System.out.println("짝수인가? " + result);
	}
}