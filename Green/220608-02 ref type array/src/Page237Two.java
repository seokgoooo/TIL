import java.util.Scanner;

public class Page237Two {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[10];
		int[] count = new int[10];
		int j = 0;
		int check = 0;
		int range = 1;

		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();

			while (j < 100) {
				if (num[i] > j && num[i] < j + 11) {
					count[check]++;
					break;
				} else {
					check++;
					j += 10;
				}
			}
			check = 0;
			j = 0;
		}
		
		scan.close();

		for (int i = 0; i < count.length; i++) {
			System.out.printf("%d ~ %d: ", range, range + 9);
			for (int k = 0; k < count[i]; k++) {
				System.out.print("*");
			}
			System.out.println();
			range = range + 10;
		}
	}
}