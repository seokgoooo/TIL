import java.util.Scanner;
public class Gcd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, r;
		x = sc.nextInt();
		y = sc.nextInt();
		
		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		System.out.printf("최대 공약수는 %d입니다.\n", x);
	}
}