import java.util.Scanner;

public class Q2562 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[9];
		int max = 0;
		int count = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
			
			if (num[i] > max) {
				max = num[i];
				count = i + 1;
			}
		}
		
		System.out.println(max);
		System.out.println(count);
	}
}