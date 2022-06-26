// page73.1번.2번.3번
// page101.2번
// page102.6번
// 사용자가 입력한 5자리의 정수를 역순으로 출력하는 프로그램 예) 12345 -> 54321

import java.util.Scanner;

public class BookExample {
	public static void main(String[] args) {
		// Page73 One
		Scanner scan = new Scanner(System.in);
		System.out.print("마일을 입력하시오: ");
		double mile = scan.nextDouble();
		double kilometer = (1.609 * mile);
		System.out.println(mile + "마일은 " + kilometer + "킬로미터입니다.");

		// Page73 Two
		System.out.print("받은 돈을 입력하시오: ");
		int inputMoney = scan.nextInt();
		System.out.print("상품의 총액을 입력하시오: ");
		int itemMoney = scan.nextInt();
		double tax = (itemMoney * 0.1);
		int resultMoney = (inputMoney - itemMoney);

		System.out.println("받은 돈: " + inputMoney);
		System.out.println("상품의 총액: " + itemMoney);
		System.out.println("부가세: " + tax);
		System.out.println("잔돈: " + resultMoney);

		// Page73 Three
		System.out.print("구의 반지름을 입력하시오: ");
		double radius = scan.nextDouble();
		double volume = radius * radius * radius * 4 / 3;
		// 연산식에서 계산 순서에 따라 앞에 있는 실수 / 정수 타입을 따라간다
		System.out.println("구의 부피: " + volume);

		// Page101 Two
		System.out.print("첫번째 정수를 입력하시오: ");
		int firstInt = scan.nextInt();
		System.out.print("두번째 정수를 입력하시오: ");
		int secondInt = scan.nextInt();
		int divisionInt = secondInt / firstInt;
		int remainderInt = secondInt % firstInt;
		System.out
				.println(secondInt + "을 " + firstInt + "으로 나눈 몫은 " + divisionInt + "이고 나머지는 " + remainderInt + "입니다.");
		System.out.printf("%d을 %d으로 나눈 몫은 %d이고 나머지는 %d입니다.", secondInt, firstInt, divisionInt, remainderInt);
		// printf : %d 등 서식 사용할 수 있음

		// Page102 Six
		System.out.print("500원 동전의 개수를 입력하시오: ");
		int coin500 = scan.nextInt();
		System.out.print("100원 동전의 개수를 입력하시오: ");
		int coin100 = scan.nextInt();
		System.out.print("50원 동전의 개수를 입력하시오: ");
		int coin50 = scan.nextInt();
		System.out.print("10원 동전의 개수를 입력하시오: ");
		int coin10 = scan.nextInt();
		int totalCoin = (coin500 * 500) + (coin100 * 100) + (coin50 * 50) + (coin10 * 10);
		System.out.println("저금통이 들어 있는 돈의 액수: " + totalCoin);
	}
}