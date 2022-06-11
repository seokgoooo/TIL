import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 6, 8, 10 };
		int[] arr2 = { 3, 6, 9, 12, 15 };
		int[] arr3 = { 4, 8, 12, 16, 20 };

		int[][] arr2d = new int[3][5];

//		[3] : { arr1, arr2, arr3 }	배열 개수의 길이 (행) 가로
//		[5] : { 2, 4, 6, 8, 10 }	각 배열의 길이	(열) 세로

		
//		arr2d.length = 행의 길이
//		arr2d[i].length = 열의 길이
		
		arr2d[0] = arr1;
		arr2d[1] = arr2;
		arr2d[2] = arr3;

		for (int i = 0; i < arr2d[0].length; i++) {
			System.out.println(arr2d[0][i]);
		}

		for (int j = 0; j < arr2d.length; j++) {	
			for (int i = 0; i < arr2d[j].length; i++) {
				System.out.print(arr2d[j][i]);
			}
			System.out.println();
		}
		
//		다음과 같이 [0]번 배열에 이름이 없을때 쓰려고 위에 처럼 쓴다.
//		int[][] arrAnother = { { 2, 4, 6 }, { 3, 6, 9 }, { 4, 8, 12 } };
//		for (int i = 0; i < arrAnother[0].length; i++) {
//			System.out.println(arrAnother[0][i]);
//		}
		
//		System.out.print(arr2d[0][0]);
//		System.out.print(arr2d[0][1]);
//		System.out.print(arr2d[0][2]);
//		System.out.print(arr2d[0][3]);
//		System.out.println(arr2d[0][4]);
		
		System.out.println(Arrays.toString(arr2d[1]));
		System.out.println(Arrays.toString(arr2d[2]));

	}
}