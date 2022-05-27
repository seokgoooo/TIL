import java.util.Scanner;

public class Q10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] numbers = new int[a];
		int min = -1000001;
		int max = 1000001;
		for (int i = 0; i < a; i++) {
			numbers[i] = sc.nextInt();
		}
		
		for (int i = 0; i < a; i++) {
			if (max <= numbers[i]) {
				max = numbers[i];
			}
		}
		
		for (int i = 0; i < a; i++) {
			if (min >= numbers[i]) {
				min = numbers[i];
			}
		}
		System.out.print(min + " " + max);
	}
}