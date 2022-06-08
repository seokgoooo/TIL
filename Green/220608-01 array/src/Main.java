public class Main {
	public static void main(String[] args) {
		// 다음과 같은 정수형 배열이 있을 때
		int[] arr = { 15, 32, 222, 119, 534, 36, 9, 1234 };

		// 2자리 수의 개수와 목록을 콘솔창에 출력해보세요~
		
		// 개수 : 3
		// -- 목록 --
		// 15
		// 32
		// 36
		int[] count = new int[4];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] < 10) {
				count[0]++;
			} else if (arr[i] >= 10 && arr[i] < 100) {
				count[1]++;
			} else if (arr[i] >= 100 && arr[i] < 1000) {
				count[2]++;
			} else if (arr[i] >= 1000 && arr[i] < 10000) {
				count[3]++;
			}
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}

		System.out.println("----------");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] < 10) {
				System.out.println(arr[i]);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 10 && arr[i] < 100) {
				System.out.println(arr[i]);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 100 && arr[i] < 1000) {
				System.out.println(arr[i]);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 1000 && arr[i] < 10000) {
				System.out.println(arr[i]);
			}
		}
	}
}