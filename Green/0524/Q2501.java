import java.util.Scanner;
public class Q2501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int j = 1;
		int[] arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = -1;
		}
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				arr[j] = i;
				j++;
			}
		}
		
		if (arr[k] == -1) {
			System.out.println(0);
		} else {
			System.out.println(arr[k]);
		}
	}
}