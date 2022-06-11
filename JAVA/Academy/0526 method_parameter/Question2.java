// 2. 전달받은 정수만큼 "안녕"이라는 문자열을 출력하는 메소드. (return type : void)
import java.util.Scanner;
public class Question2 {
	public static void hello() {
		System.out.print("숫자 입력: ");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		for (int i = 1; i <= r; i++) {
			System.out.println("안녕");
		}
	}
	
	public static void main(String[] args) {
		hello();
	}
}