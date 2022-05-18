import java.util.Scanner;

public class Page101Two {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하시오: ");
		int x = input.nextInt();
				
		System.out.print("두번째 정수를 입력하시오: ");
		int y = input.nextInt();
		
		int div = y / x;
		int mar = y % x;
		
		System.out.println(y + "을 " + x + "으로 나눈 몫은 " + div + "이고 나머지는 " + mar + "입니다.");
	}
}