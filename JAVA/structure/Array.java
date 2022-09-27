package structure;

public class Array {
	public static void insert(int idx, int num, int arr[], int len) {
//		0, 1, 2
//		0, 1, 2, 3	 len + 1
//		0, 1, 2, 3, 4
//		0, 1, 2, 3, 4, 5

		if (idx == len) {
			arr[idx] = num;
		}

		for (int i = 0; i < arr.length; i++) {
			if (i + 1 >= arr.length) {

			} else {
				arr[i + 1] = arr[i];
			}
		}
	}

	public static void erase(int idx, int arr[], int len) {

	}

	public static void printArr(int arr[], int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void insert_test() {
		System.out.println("***** insert_test *****");
		int[] arr = new int[] { 10, 20, 30 };
		int len = 3;

		insert(3, 40, arr, len); // 10 20 30 40
		printArr(arr, len);
		insert(1, 50, arr, len); // 10 50 20 30 40
		printArr(arr, len);
		insert(0, 15, arr, len); // 15 10 50 20 30 40
		printArr(arr, len);
	}

	public static void erase_test() {
		System.out.println("***** erase_test *****");
		int[] arr = { 10, 50, 40, 30, 70, 20 };
		int len = 6;

		erase(4, arr, len); // 10 50 40 30 20
		printArr(arr, len);
		erase(1, arr, len); // 10 40 30 20
		printArr(arr, len);
		erase(3, arr, len); // 10 40 30
		printArr(arr, len);
	}

	public static void main(String[] args) {
		insert_test();
		erase_test();
	}
}
