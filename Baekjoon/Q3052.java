import java.util.Scanner;

public class Q3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] result = new int[10];
		int count = 0;

		for (int i = 0; i < result.length; i++) {
			result[i] = scan.nextInt() % 42;
		}
		for (int i = 0; i < result.length; i++) {
			int temp = -1;
			for (int j = i; j < result.length; j++) {
				if (result[i] == result[j]) {
					temp++;
				}
			}
			if (temp == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}