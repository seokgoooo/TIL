import java.util.Scanner;
public class Q13015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
		// 처음 라인
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
		}
		
		for (int i = 2; i <= n; i++) {
			System.out.print(" ");
		}
		
		for (int i = 3; i <= n; i++) {
			System.out.print(" ");
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
		}
			System.out.println();
		
		// 위쪽 V라인
        for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == i) {
					System.out.print("*");
					continue;
				} else {
					System.out.print(" ");
				}		
            }
			
			for (int j = 2; j <= n; j++) {
				if (j == i) {
					System.out.print("*");
					continue;
				} else {
					System.out.print(" ");
				}		
            }
			
			for (int j = n - 1; j >= i; j--) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}		
            }
			
			for (int j = 3; j <= i; j++) {
				System.out.print(" ");
			}
			
			
			for (int j = n; j >= i; j--) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}		
            }
            System.out.println();
        }
		
		// 아래쪽 ㅅ라인
		for (int i = 1; i <= n - 2; i++) {
			for (int j = n - 1; j >= i; j--) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
            }
			
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			
			for (int j = n - 2; j >= i; j--) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}		
            }
			
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j < n; j++) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}		
            }
			
			for (int j = 1; j <= n; j++) {
				if (j == i) {
					System.out.print("*");
					continue;
				} else {
					System.out.print(" ");
				}		
            }
            System.out.println();
        }
		
		// 마지막 라인
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
		}
		
		for (int i = 2; i <= n; i++) {
			System.out.print(" ");
		}
		
		for (int i = 3; i <= n; i++) {
			System.out.print(" ");
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
		}
    }
}

// *****       *****
 // *   *     *   *
  // *   *   *   *
   // *   * *   *
    // *   *   *
   // *   * *   *
  // *   *   *   *
 // *   *     *   *
// *****       *****