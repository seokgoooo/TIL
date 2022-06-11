import java.util.Arrays;

public class Main {
	public static void insertionSort(int[] arr) {
		for (int index = 1; index < arr.length; index++) {
			int temp = arr[index];
			int aux = index - 1;

			while ((aux >= 0) && (arr[aux] > temp)) {

				arr[aux + 1] = arr[aux];
				aux--;
			}
			arr[aux + 1] = temp;
		}
	}

	public static void main(String[] args) {
//		Book[] books = new Book[3];
//		books[0] = new Book("작별인사", "김영하", "복복서가", "장편소설", 12600);
//		books[1] = new Book("불편한 편의점", "김호연", "나무옆의자", "장편소설", 12600);
//		books[2] = new Book("지금 알고 있는 걸 그때도 알았더라면", "류시화", "열림원", "시집", 8100);
//		
//		Arrays.sort(books); // 정렬 기준을 모르기 때문에 컴파일 에러는 안나지만 실행 에러가 나는 것이다
		int[] arr = { 50, 30, 20, 60, 10 };

//		insertionSort(arr);
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 20);	// index 값이 겹치지 않아야 한다.
		System.out.println("20의 인덱스: " + index);

		System.out.println(Arrays.toString(arr));
	}
}
