// 0부터 원하는 숫자까지 출력

import java.util.Scanner;
public class WantRepeat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = 0;
		
		while (y < x) {
			System.out.println(y);
			y++;
		}
	}
}