import java.util.Scanner;

public class Q1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int original = N;
		
		while (true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10); 
			count++;
			if (original == N) {
				break;
			}
		}
		System.out.println(count);
	}
}