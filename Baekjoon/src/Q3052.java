import java.util.Scanner;

public class Q3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] input = new int[10];
		int[] result = new int[10];
		int count = 0;

		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextInt();
			result[i] = input[i] % 42;
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (i != j) {
					if (result[i] == result[j]) {
						count++;
					} else {
						continue;
					}
				}
			}
		}

		System.out.println(count);
	}
}
