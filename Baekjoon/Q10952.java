import java.util.Scanner;

public class Q10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
			
			if ( a == 0 && b == 0 ) {
				break;
			}
		}
	}
}