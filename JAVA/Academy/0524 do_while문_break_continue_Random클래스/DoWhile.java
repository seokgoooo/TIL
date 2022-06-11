import java.util.Scanner;
public class DoWhile {
	public static void main(String[] args) {
		// while (false) {
			// 문장1
		// }
		
		Scanner sc = new Scanner(System.in);
		System.out.println("10을 나눌 수 입력하셍");
		
		int num;
		do {
			num = sc.nextInt();
			if (num == 0) {
			System.out.println("0으로 나눌 수 없음");
			}
		} while (num == 0);
			System.out.println(10 / num);
		
		// do {
			// System.out.println("실행 되나?");
		// }	while (false);
	}
}