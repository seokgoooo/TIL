// 사용자의 나이와 이름을 입력받아서 입력값이 본인과 같으면 true, 아니면 false

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요: ");
		int age = scan.nextInt();

		scan.nextLine();
		System.out.print("이름을 입력하세요: ");
		String name = scan.nextLine();
		
		System.out.println(age == 1 && name.equals("이름"));
	}
}