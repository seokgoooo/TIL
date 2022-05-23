// 사용자의 입력 n, m 출력 : n의 m제곱
import java.util.Scanner;
public class Question2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
				
		long result = n;
		for(int i = 0; i < (m - 1); i++) {
			result *= n;
		}
		System.out.println(result);
	}
}