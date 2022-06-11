// 3. 전달받은 두 문자열의 길이 값의 합을 반환하는 메소드.
import java.util.Scanner;
public class Question3 {
	public static int length(String a, String b) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력: ");
		a = sc.nextLine();
		System.out.print("문자 입력: ");
		b = sc.nextLine();
		
		return a.length() + b.length();
	}
	
	public static void main(String[] args) {
		String a = " ";
		String b = " ";
		System.out.println("문자열 길이 값의 합 : " + length(a, b));
	}
}