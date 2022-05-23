import java.util.Scanner;
public class Gugudan {
	public static void main(String[] args) {
		// 구구단 4단
		// Scanner sc = new Scanner(System.in);
		// int i = 1;
				
		// while (i <= 9) {
			// System.out.println(4 + " * " + i + " = " + (4 * i));
			// i++;
			
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int i = 1;
				
		while (i <= 9) {
		System.out.println(x + " * " + i + " = " + (x * i));
		i++;
		}
	}
}