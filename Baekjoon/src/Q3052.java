import java.util.Scanner;

public class Q3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] input = new int[10];
		int[] result = new int[10];
		int indexNumber = 0;
		int count = 0;

		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextInt();
			result[i] = input[i] % 42;
		}

		while (indexNumber < result.length) {
			for (int i = 0; i < result.length; i++) {
				if (result[indexNumber] == result[i]) {
					if (indexNumber == i) {
						continue;
					} else {
						count++;
						break;
					}
				} else if (result[indexNumber] != result[i]) {

				}
			}
			indexNumber++;
		}

		System.out.println(10 - count);
	}
}