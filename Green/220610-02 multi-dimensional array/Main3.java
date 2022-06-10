import java.util.Arrays;
import java.util.Random;

public class Main3 {
	public static void main(String[] args) {
		int[][] randomArray = randomArray();
		print2D(randomArray);
		// 각 행의 합
		sumRow(randomArray);
		// 각 열의 합
		sumColumn(randomArray);
		// 숫자 7의 개수
		countSeven(randomArray);
	}

	public static int[][] randomArray() {
		Random random = new Random();
		int[][] array = new int[5][5];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(10);
			}
		}

		return array;
	}

	public static void print2D(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	public static void sumRow(int[][] array) {
		int[] sumRow = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sumRow[i] += array[i][j];
			}
		}
		System.out.println(Arrays.toString(sumRow));
	}

	public static void sumColumn(int[][] array) {
		int[] sumColumn = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sumColumn[i] += array[j][i];
			}
		}
		System.out.println(Arrays.toString(sumColumn));
	}

	public static void countSeven(int[][] array) {
		int count = 0;
		Integer check = Integer.valueOf(7);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == check) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}