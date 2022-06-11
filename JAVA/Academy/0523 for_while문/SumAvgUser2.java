import java.util.Scanner;
public class SumAvgUser2 {
	public static void main(String[] args) {
		// 사용자가 먼저 정해서 입력한 n개의 정수의 합과 평균
		// 짝수 홀수 구분해서
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.println("n개의 정수 입력.");
		int count = sc.nextInt();
		
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < count; i++) {
			// 연산
			sum = sc.nextInt();
			if (sum % 2 == 0) {
				sum2 += sum;
				y++;
			}
			else {
				sum1 += sum;
				x++;
			}
		}
		
		// 출력
		System.out.println("홀수 합: " + sum1);
		System.out.println("홀수 평균: " + sum1 / x);
		System.out.println("짝수 합: " + sum2);
		System.out.println("짝수 평균: " + sum2 / y);
	}
}