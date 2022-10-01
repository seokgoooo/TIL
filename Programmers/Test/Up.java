package Al;

class Solution {
	public int solution(int[] arr) {
		int answer = 0;
		boolean plus = true;
		int[] length = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 10) {
				plus = false;
			}

//			숫자 길이 비교를 위한 배열
			length[i] = (int) Math.log10(arr[i] + 1);
//			숫자 각 자리마다 비교를 위한 배열
			int temp = 0;
			while (arr[i] > 0) {
				temp += arr[i] % 10;
				arr[i] /= 10;
			}
			arr[i] = temp;
		}

//		길이가 다르면 비교 x,
//		같으면 자리마다 비교 o 확인 후 같으면 sum = 0, arr = 0
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (length[j] == -1) {

				} else {
					if (length[i] == length[j]) {
						if (arr[i] == arr[j]) {
							answer++;
							length[i] = -1;
							length[j] = -2;
							arr[i] = -1;
							arr[j] = -2;
						}
					} else {
						continue;
					}
				}
			}
		}

		if (plus) {
			answer++;
		}

		return answer;
	}
}

public class LG1 {
	public static void main(String[] args) {
		int[] arr = { 112, 1814, 121, 1481, 1184 };
		int[] arr1 = { 123, 456, 789, 321, 654, 987 };
		int[] arr2 = { 1, 2, 3, 1, 2, 3, 4 };
		int[] arr3 = { 123, 234, 213, 432, 234, 1234, 2341, 12345, 324 };

		System.out.println(new Solution().solution(arr));
		System.out.println(new Solution().solution(arr1));
		System.out.println(new Solution().solution(arr2));
		System.out.println(new Solution().solution(arr3));
	}
}