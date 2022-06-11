import java.util.Scanner;
public class Q2445 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j <= i; j++) {
				
				System.out.print("*");
			
			}
			
			for (int j = n; j > i + 1; j--) {
				
				System.out.print(" ");
				
			}
			
			for (int j = n; j > i + 1; j--) {
				
				System.out.print(" ");
				
			}
			
			for (int j = 0; j <= i; j++) {
				
				System.out.print("*");
			
			}
			
			System.out.println();
			
		}
		
		for (int i = n; i > 1; i--) {
			
			for (int j = i; j > 1; j--) {
				
				System.out.print("*");
			
			}
			
			for (int j = 0; j <= n - i; j++) {
				
				System.out.print(" ");
				
			}
			
			for (int j = 0; j <= n - i; j++) {
				
				System.out.print(" ");
				
			}
			
			for (int j = i; j > 1; j--) {
				
				System.out.print("*");
			
			}
			
			System.out.println();
			
		}
	}
}

// *        *
// **      **
// ***    ***
// ****  ****
// **********
// ****  ****
// ***    ***
// **      **
// *        *