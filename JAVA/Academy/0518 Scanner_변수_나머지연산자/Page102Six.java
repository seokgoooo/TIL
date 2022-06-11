import java.util.Scanner;

public class Page102Six {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("500원 동전의 개수를 입력하시오: ");
		int coin500 = input.nextInt();
	
		System.out.print("100원 동전의 개수를 입력하시오: ");
		int coin100 = input.nextInt();
		
		System.out.print("50원 동전의 개수를 입력하시오: ");
		int coin50 = input.nextInt();
		
		System.out.print("10원 동전의 개수를 입력하시오: ");
		int coin10 = input.nextInt();
					
		int total = (coin500 * 500) + (coin100 * 100) + (coin50 * 50) + (coin10 * 10);
		
		System.out.println("저금통이 들어 있는 돈의 액수: " + total);
	}
}