public class Sum {
	public static void main(String[] args) {
		// 0 ~ 100 범위의 정수의 합
		// int sum = 0;
		// for(int i = 0; i <= 100; i++) {
			// sum += i;
		// }
		// System.out.printf("0부터 100까지의 정수 합 = %d\n", sum);
		
		// 100 ~ 200 사이의 짝수의 합
		int sum = 0;
		for(int i = 100; i <= 200; i += 2) {
			System.out.print(i);
			sum += i;
		}
		System.out.printf("100부터 200까지의 짝수 합 = %d\n", sum);
	}
}