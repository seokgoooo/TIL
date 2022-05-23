// 입력 : 정수 / 출력 : 짝수 나열하고 총 개수
import java.util.Scanner;
public class Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇가지의 정수인가요?: ");
		int total = sc.nextInt();
		int numcount = 0;
		
		for (int i = 0; i < total; i++) {
			System.out.println(total + "개의 정수 입력");
			int num = sc.nextInt();
			if (num % 2 == 0) {
				System.out.println("짝수: " + num);
				numcount++;
			}
		}
		System.out.println("짝수 총 개수: " + numcount);
	}
}
