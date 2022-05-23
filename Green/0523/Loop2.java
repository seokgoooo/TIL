// 1 ~ 10000까지 출력하세요

public class Loop2 {
	public static void main(String[] args) {
		// int i = 1;
		// while (i <= 10) {
			// System.out.println("반복됩니다.");
			// i++;
		// }
		
		// 20 ~ 29까지 출력하기
		// int i = 20;
		// while (i <= 29) {
			// System.out.println(i + "반복됩니다");
			// i++;
		// }			
		
		// 10 ~ 0까지
		// int x = 10;
		// while (x >= 0) {
			// System.out.println(x + "반복됩니다");
			// x--;
		// }
		
		// 3의 배수를 출력해보세요
		// int y = 0;
		// while (y < 100) {
			// System.out.println(y);
			// y += 3;
		// }
		
		// ☆
		// ★
		// ☆
		// ★ 출력하기
		
		int x = 0;
		while (x <= 20) {
			if (x % 2 == 0) {
				System.out.println("☆");	
			} else {
				System.out.println("★");
			}
			x++;
		}
	}
}