// 이런식으로 메소드 만드는 연습을 해봤다.
// 다행스럽게도 이러한 메소드들은 Arrays 클래스에 만들어져있다.
// 
import java.util.Arrays;

public class Main4 {
	// 두 개 정수 배열을 전달받아 결합시켜 반환하는 메소드
	// 예) [1,2,3] [10,11,12,13,14]
	// [1,2,3,10,11,12,13,14]
	public static int[] combination(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];
		for (int i = 0; i < one.length; i++) {
			result[i] = one[i];
		}

		for (int i = one.length; i < result.length; i++) {
			result[i] = two[i - one.length];
		}

		return result;
	}

	// 두 개 정수 배열의 합을 가지는 배열을 반환하는 메소드
	// 예) [1,2,3] [10,11,12,13,14]
	// [11, 13, 15, 13, 14]
	public static int[] sum(int[] one, int[] two) {
		int[] result = new int[two.length];
		for (int i = 0; i < one.length; i++) {
			result[i] = one[i] + two[i];
		}

		for (int i = one.length; i < result.length; i++) {
			result[i] = two[i];
		}

		return result;
	}

	// Teacher ver.
	// 두 개 정수 배열을 전달받아 결합시켜 반환하는 메소드
	// 예) [1, 2, 3] [10, 11, 12, 13, 14]
	// [1, 2, 3, 10, 11, 12, 13, 14]
	// 2번 작성 메소드
	public static int[] concatArray(int[] left, int[] right) {
		int[] newArray = copy(left, right.length);

		for (int i = left.length; i < newArray.length; i++) {
			newArray[i] = right[i - left.length];
		}
		return newArray;
	}

	// 두 개 정수 배열의 합을 가지는 배열을 반환하는 메소드
	// 예) [1, 2, 3] [10, 11, 12, 13, 14]
	// [11, 13, 15, 13, 14]
	// 3번 작성 메소드
	public static int[] sumArray(int[] left, int[] right) {
		if (left.length > right.length) {
			int[] copy = copy(left, 0);
			for (int i = 0; i < right.length; i++) {
				copy[i] += right[i];
			}
			return copy;
		} else {
			int[] copy = copy(right, 0);
			for (int i = 0; i < left.length; i++) {
				copy[i] += left[i];
			}
			return copy;
		}
	}
	
//	중첩된 표현 피해서 다르게 적기.
//	public static int[] sumArray(int[] left, int[] right) {
//		copy = left.length > right.length ? copy(left, 0) : copy(right, 0);
//		int[] copy;
//		int[] target;
//		
//		if (left.length > right.length) {
//			copy = copy(left, 0);
//			target = right;
//		} else {
//			copy = copy(right, 0);
//			target = left;
//		}
//		
//		for (int i = 0; i < target.length; i++) {
//			copy[i] += target[i];
//		}
//		
//		return copy;
//	}

	// 1번 작성 메소드
	public static int[] copy(int[] arr, int newLength) {
		int[] larger = new int[arr.length + newLength];
		for (int i = 0; i < arr.length; i++) {
			larger[i] = arr[i];
		}
		return larger;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		int[] larger = new int[arr.length + 2];

		for (int i = 0; i < arr.length; i++) {
			larger[i] = arr[i];
		}

		System.out.println(Arrays.toString(larger));

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		int[] one = { 1, 2, 3 };
		int[] two = { 10, 11, 12, 13, 14 };
		System.out.println(Arrays.toString(combination(one, two)));
		System.out.println(Arrays.toString(sum(one, two)));
	}
}
