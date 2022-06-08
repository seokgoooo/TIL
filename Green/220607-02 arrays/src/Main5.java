import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//사용자에게 5번의 정수를 입력받아 최근 입력한 순(역순)으로 출력하기
//예) 10 20 30 40 50 -> 50 40 30 20 10

		int[] reverse = new int[4];

		for (int i = 0; i < 5; i++) {
			System.out.print("정수 입력: ");
			reverse[i] = scan.nextInt();
		}

		for (int i = 4; i >= 0; i--) {
			System.out.println(reverse[i]);
		}

//사용자가 0이하의 정수를 입력할 때까지 반복하여 입력
//최근 5개를 출력
//10 20 30 40 50 60 70 80 90 100 -1 -> 100 90 80 70 60

		int stop = 0;
		int i = 0;
		int[] zero = new int[100];

		while (true) {
			System.out.print("input: ");
			zero[i] = scan.nextInt(); // zero[0] 부터 값을 입력 받음. 반복되면 1씩 증가.

			if (zero[i] <= 0) { // zero 배열에 0 이하의 정수가 입력되면 그 때의 index 값을 stop 에 저장
				stop = i;
				break;
			}
			i++;
		}

		for (int j = stop - 5; j < stop; j++) { // 0 이하의 정수가 입력 되기 이전 5개의 배열 값을 출력
			if (j >= 0)							// 배열의 index는 0 이상의 정수.
				System.out.print(zero[j] + " ");
		}
	}
}
