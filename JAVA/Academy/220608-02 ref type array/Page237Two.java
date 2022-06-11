import java.util.Scanner;

public class Page237Two {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] inputNumber = new int[10];			// 입력 받은 정수를 넣어줄 배열
		int[] countRange = new int[10];				// rangeSmall ~ rangeLarge 까지 범위의 정수 개수를 넣어줄 배열
		int rangeIndex = 0;					// 정수 개수 배열의 index를 나타내줄 변수
		int rangeSmall = 0;					// 범위의 작은 부분을 나타내줄 변수
		int rangeLarge = 11;					// 범위의 큰 부분을 나타내줄 변수

		// 정수가 범위에 맞는지 확인하는 반복문
		for (int i = 0; i < inputNumber.length; i++) {						// 배열 inputNumber 의 길이까지 반복해서 입력
			inputNumber[i] = scan.nextInt();

			while (rangeSmall < 100) {							// 마지막 범위가 91 ~ 100 이다. 때문에 rangeSmall이 100 보다 작을 때 까지 실행
			
				if (rangeSmall < inputNumber[i] && inputNumber[i] < rangeLarge) {	// inputNumber[0] 가 0 보다 크고 11 보다 작을 때. 즉 1 ~ 10 까지의 범위
					countRange[rangeIndex]++;					// 범위 안에 있으면 countRange[0] 의 값을 1 증가
					break;								// inputNumber[0] 의 범위를 찾았기 때문에 break로 반복문 종료
				} else {
					rangeIndex++;							// 범위에 있지 않은 경우 rangeIndex 값을 1 증가 시켜 countRange[1] 의 개수를 확인
					rangeSmall += 10;						// 다음 범위인 11 ~ 20 로 가기 위해 각각 range 의 값을 10 증가
					rangeLarge += 10;
				}
				
			}
			
			rangeIndex = 0;
			rangeSmall = 0;
			rangeLarge = 11;
			// 범위에 맞는지를 확인하고 나면 다시 처음 범위부터 반복하기 위해
			// rangeIndex 와 각각 range 값을 초기값으로 초기화
		}
		
		// eclipse 에서 scan 변수에 자꾸 경고가 뜨기 때문에 메소드로 종료
		scan.close();					

		// 출력을 위해 범위 값 설정
		rangeSmall = 1;
		rangeLarge = 10;
		
		// 범위 문자열과 별을 찍기 위한 반복문
		for (int i = 0; i < countRange.length; i++) {					// countRange 배열 길이까지 반복
			System.out.printf("%d ~ %d: ", rangeSmall, rangeLarge);			// 1 ~ 10: 이란 문자열 출력
			
			for (int j = 0; j < countRange[i]; j++) {				// countRange[i] 값 만큼 * 반복해서 출력
				System.out.print("*");
			}
			
			// * 출력이 끝나면 각각 range 값을 10 증가시켜 다음 출력문을 11 ~ 20 으로 만들고 끝날때 까지 반복
			System.out.println();
			rangeSmall += 10;
			rangeLarge += 10;
		}
	}
}
