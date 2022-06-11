// (1) (2) (3) (4) (5)
// (5) (4) (3) (2) (1)
// (1) (2) (3) (4) (5)
// (5) (4) (3) (2) (1)
// (1) (2) (3) (4) (5)


public class Print2D2 {
	public static void main(String[] args) {
		for (int i = 5; i <= 1; i--) {
			
			for (int j = 1; j <= 5; j++) {
				
				System.out.printf("(%d)", j);
			}
			
			// System.out.printf("\n(%d)", i);
			
		}
	}
}