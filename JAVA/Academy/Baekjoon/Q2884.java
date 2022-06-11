import java.util.Scanner;

public class Q2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        // if (H == 0) {
            // if (M == 45) {
                // System.out.println(H + " " + 0);
            // } else if (M > 45) {
                // System.out.println(H + " " + (M - 45));
            // } else {
                // System.out.println(23 + " " + (M + 15));
            // }
        // } else if (M == 45) {
            // System.out.println(H + " " + 0);
        // } else if (M > 45) {
            // System.out.println(H + " " + (M - 45));
        // } else {
            // System.out.println((H - 1) + " " + (M + 15));
        // }
		
		if (M == 45) {
			System.out.println(H + " " + 0);
		} else if (M > 45) {
			System.out.println(H + " " + (M - 45));
			} else {
				if (H == 0) {
					System.out.println(23 + " " + (M + 15));
				}
				else {
					System.out.println((H - 1) + " " + (M + 15));
				}
				}
    }
}