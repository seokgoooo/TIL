// 2 3 4 5 6
// 3 4 5 6 7
// 4 5 6 7 8
// 5 6 7 8 9
// 6 7 8 9 10

public class Jungol547 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j <= 4; j++) {
				System.out.print(i + j);
			}
			System.out.println();
		}
	}
}