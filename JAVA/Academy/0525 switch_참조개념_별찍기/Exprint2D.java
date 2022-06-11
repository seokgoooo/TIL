// (1) (2) (3) (4) (5)
// (5) (4) (3) (2) (1)
// (1) (2) (3) (4) (5)
// (5) (4) (3) (2) (1)
// (1) (2) (3) (4) (5)


public class Exprint2D {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			if (i % 2 == 0) {
				
				System.out.println("(5)(4)(3)(2)(1)");
				continue;
				}
			
			for (int j = 1; j <= 5; j++) {
				System.out.printf("(%d)", j);
			}
			System.out.println(" ");
		}
	}
}