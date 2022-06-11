// 입력 : 5개의 정수 / 출력 : 가장 큰 수
import java.util.Scanner;
public class Question5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int max = 0;
		
		for (int i = 0; i < 5; i++) {
			System.out.print("5개의 정수 입력: ");
			num[i] = sc.nextInt();
			if (num[max] < num[i]) {
				max = i;
			}
		}
		System.out.println("가장 큰 수: " + num[max]);
	}
}