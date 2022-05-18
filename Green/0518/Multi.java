// 사용자에게 정수 하나를 입력받아서 제곱값을 출력
import java.util.Scanner;

public class Multi {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오: ");
		int x = input.nextInt();
				
		System.out.printf("정수의 제곱값: " + (x * x));	
		}
}