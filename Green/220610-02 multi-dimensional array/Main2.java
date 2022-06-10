import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) {

		int[][] square = { { 2, 4, 8, 16, 32 }, { 3, 9, 27, 81, 243 }, { 4, 16, 64, 256, 1024 },
				{ 5, 25, 125, 625, 3125 } };

		for (int j = 0; j < square.length; j++) {
			for (int i = 0; i < square[j].length; i++) {
				System.out.print(square[j][i]);
			}
			System.out.println();
		}

		int[][] square2 = new int[4][5];
		for (int i = 0; i < square2.length; i++) {
			int n = 1;
			for (int j = 0; j < square2[i].length; j++) {
				n *= 2 + i;
				square2[i][j] = n;
			}
		}

		System.out.println(Arrays.toString(square));
		System.out.println(Arrays.deepToString(square));
		System.out.println(Arrays.toString(square2));
		System.out.println(Arrays.deepToString(square2));

		System.out.println(square == square2);
		System.out.println(Arrays.equals(square, square2));
		System.out.println(Arrays.deepEquals(square, square2));
	}
}