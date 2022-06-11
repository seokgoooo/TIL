public class Count {
	public static void main(String[] args) {
		// 100 ~ 400 사이 정수 중
		// 13의 배수를 찾아 몇 개가 있는지 출력
		int count = 0;
		for (int i = 100; i <= 400; i++) {
			if (i % 13 == 0) {
				// 개수를 세야함
				System.out.println("확인: " + i);
				count++;
			}
		}
		System.out.println(count);
	}
}