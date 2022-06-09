import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int result = a * b * c;
		int num = 0;
		int[] count = new int[10];
		
		while ( result > 0 ) {
			num = result % 10;
			count[num]++;
			result = result / 10;
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}