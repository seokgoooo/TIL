import java.util.Scanner;
public class Q2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		for( int y = 0; y < n; y++ ) {
			for( int x = 0; x <= y; x++ ) {
			System.out.print("*");
			}
			System.out.println("");
		}
	}
}