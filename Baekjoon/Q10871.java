import java.util.Scanner;

public class Q10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int x = sc.nextInt();
		int[] n = new int[count];
		
		for (int i = 0; i < count; i++) {
			n[i] = sc.nextInt();
		}
		
		for (int j = 0; j < count; j++) {
			if (n[j] < x) {
				System.out.print(n[j] + " ");
			}
		}
	}
}