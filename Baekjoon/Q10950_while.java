import java.util.Scanner;
public class Q10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int x = 0;
		while (x <= i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
			x++;
		}
	}
}