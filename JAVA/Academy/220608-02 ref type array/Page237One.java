import java.util.Scanner;

public class Page237One {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[10];
		
		while (true) {
			System.out.print("좌석을 예약하시겠습니까? (1 또는 0) ");
			int input = scan.nextInt();
			
			if (input == 1) {
				System.out.println("현재의 예약 상태는 다음과 같습니다.");
				System.out.println("-------------------------");
				for (int i = 1; i <= 10; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
				System.out.println("-------------------------");
				for (int i = 0; i < seat.length; i++) {
					System.out.print(seat[i] + " ");
				}
				System.out.println();
				System.out.println("몇번째 좌석을 예약하시겠습니까?");
				int reserveSeat = scan.nextInt();
				if (reserveSeat > 0 && reserveSeat < 11) {
					seat [reserveSeat - 1] = 1;
					System.out.println("예약되었습니다.");
				} else {
					System.out.println("다시 입력하세요");
				}
			}
			
			if (input == 0) {
				break;
			}
		}
		scan.close();
	}
}