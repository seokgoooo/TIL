import java.util.Arrays;

public class Main3 {
	// 정수형 배열을 전달받아 같은 길이와 원소값을 가지는 정수 배열을 반환하는 메소드
	public static int[] copyArray(int[] origin) {
		int[] copy = new int[origin.length];

		for (int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}

		return copy;
	}

	// 정수형 배열 2개가 동일한지(길이와 각 원소값)을 알 수 있는 메소드
	public static void equalArr(int[] origin, int[] verse) {
		if (origin.length == verse.length) {
			System.out.println("길이 같다");
			System.out.println(Arrays.equals(origin, verse));
		} else {
			System.out.println("길이 다르다");
		}
	}

	// Teacher ver.
	public static boolean isSame(int[] left, int[] right) {
		if (left.length != right.length) {
			return false;
		}
		
		for (int i = 0; i < left.length; i++) {
			if (left[i] != right[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[] test = { 50, 70, 90, 110 };
		int[] c = copyArray(test);
		System.out.println(Arrays.toString(c));
		equalArr(test, c);
		System.out.println(isSame(test, c));
	}
}