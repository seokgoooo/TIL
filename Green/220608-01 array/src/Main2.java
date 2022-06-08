// 배열 복사 방법

public class Main2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		
		int[] copy = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		
//		int[] copy = arr;
//		
		arr[0] = 1000;
		
		for (int i = 0; i < copy.length; i++) {
			System.out.println(copy[i]);
		}
	}
}
