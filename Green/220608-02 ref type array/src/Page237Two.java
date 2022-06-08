import java.util.Scanner;

public class Page237Two {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] inputNumber = new int[10];		// 입력 받은 정수를 넣어줄 배열
		int[] countRange = new int[10];			// range ~ range + 9 까지 범위의 정수 개수를 넣어줄 배열
		int check = 0;					// 정수 개수 배열의 index를 나타내줄 변수
		int range = 0;					// 범위를 나타내줄 변수

		// 정수가 범위에 맞는지 확인하는 반복문
		for (int i = 0; i < inputNumber.length; i++) {					// 배열 inputNumber 의 길이까지 반복해서 입력
			inputNumber[i] = scan.nextInt();

			while (range < 100) {							// 91 ~ 100까지가 마지막이기 때문에 range가 100 보다 작을 때 까지 실행
				if (inputNumber[i] > range && inputNumber[i] < range + 11) {	// range 초기값은 0. inputNumber[0] 가 0 보다 크고 11 보다 작을 때. 즉 1 ~ 10 까지의 범위
					countRange[check]++;					// 범위 안에 있으면 countRange[0] 의 값을 1 증가
					break;							// inputNumber[0] 의 범위를 찾았기 때문에 break로 반복문 종료
				} else {
					check++;						// range 범위에 있지 않은 경우 check 값을 1 증가 시켜 countRange[1] 의 개수를 확인
					range += 10;						// 다음 범위인 11 ~ 20 로 가기 위해 range 의 값을 10 증가
				}
			}
			check = 0;								// 범위에 맞는지를 확인하고 나면 다시 처음 범위부터 반복하기 위해
			range = 0;								// check 와 range 의 값을 0으로 초기화
		}
		
		scan.close();									// eclipse 에서 scan 변수에 자꾸 경고가 뜨기 때문에 메소드로 종료

		// 범위 문자열과 별을 찍기 위한 반복문
		for (int i = 0; i < countRange.length; i++) {					// countRange 배열 길이까지 반복
			System.out.printf("%d ~ %d: ", range + 1, range + 10);			// 위 반복문에서 range = 0 으로 초기화. 여기서는 1 ~ 10: 이란 문자열 출력
			for (int j = 0; j < countRange[i]; j++) {				// countRange[i] 값 만큼 * 반복해서 출력
				System.out.print("*");
			}
			System.out.println();							// * 출력이 끝나면
			range += 10;								// range에 10 증가시켜 다음 출력문을 11 ~ 20 으로 만들고 끝날때 까지 반복.
		}
	}
}
