// 정수를 입력받아 큰수에서 작은수로 나눈 몫과 나머지 출력
import java.util.Scanner;

public class BigDiv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력하세요. ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int div;
		int mod;
		
		if (x != 0 && y != 0) {
			if (x > y) {
				div = x / y;
				mod = x % y;
			}	else {
				div = y / x;
				mod = y % x;
			}
		// 이렇게 하면 한 번에 수정 가능하다 
		System.out.println("몫: " + div);
		System.out.println("나머지: " + mod);
		} else {
		System.out.println("0을 입력하지마세요");
		}
	}
}
