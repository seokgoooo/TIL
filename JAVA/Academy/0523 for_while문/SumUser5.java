import java.util.Scanner;
public class SumUser5 {
	public static void main(String[] args) {
		// 사용자가 입력한 5개의 정수의 합
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.println("5개의 정수 입력.");
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			// 연산
			sum += num;
		}
		// 출력
		System.out.println(sum);
	}
}