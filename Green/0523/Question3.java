// 자판기 프로그램 입력 : 돈 반복하여 입력을 받아
// 1번 콜라 : 1500
// 2번 사이다 : 1300
// 3번 계산
// 총 몇 개의 캔을 구입하고 거스름돈은 얼마인지 출력
import java.util.Scanner;
public class Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("돈 입력: ");
		int money = sc.nextInt();
		int coke = 0;
		int soda = 0;
		
		while (money >= 0) {
			System.out.println("*** 1번 콜라 1500원 *** 2번 사이다 1300원 *** 3번 계산 ***");
			System.out.println("1, 2, 3 중에 고르세요");
			int choose = sc.nextInt();
				if (choose == 1) {
					if (money > 1500) {
					money -= 1500;
					coke++;
					System.out.println("콜라: " + coke + "캔");
					System.out.println("사이다: " + soda + "캔");
					System.out.println("남은 돈: " + money);
					} else {
					System.out.println("남은 돈: " + money);
					System.out.println("잔액이 부족합니다.");
					money = -1;
					}
				} else if (choose == 2) {
					if (money > 1300) {
					money -= 1300;
					soda++;
					System.out.println("콜라: " + coke + "캔");
					System.out.println("사이다: " + soda + "캔");
					System.out.println("남은 돈: " + money);
					} else {
					System.out.println("남은 돈: " + money);
					System.out.println("잔액이 부족합니다.");
					money = -1;						
					}
				} else if (choose == 3) {
					System.out.println("콜라: " + coke + "캔");
					System.out.println("사이다: " + soda + "캔");
					System.out.println("거스름돈: " + money);
					money = -1;
				}
		}
	}
}