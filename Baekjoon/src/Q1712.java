import java.util.Scanner;

public class Q1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();		// 불변 비용
		long B = sc.nextLong();		// 가변 비용
		long C = sc.nextLong();		// 상품 가격
		
		if (C <= B) {
			System.out.println(-1);
		} else {
			System.out.println((A / (C - B)) + 1);
		}
	}
}