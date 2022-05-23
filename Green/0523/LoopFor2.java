public class LoopFor2 {
	public static void main(String[] args) {
		// 10 ~ 99 사이의 정수
		// for (int i = 10; i <= 99; i++) {
			// System.out.println(i);
		// }
		
		// 10의 자리 수와 1의 자리 수의 합이 7인 수만 출력
		for (int i = 10; i <= 99; i++) {
			int left = i / 10;
			int right = i % 10;
			if (left + right == 7) {
				System.out.println(i);
			}
		}
	}
}