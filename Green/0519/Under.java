// 입력 : 벤치, 스쿼트, 데드 -> 합이 500 이상이면 true, false
import java.util.Scanner;

public class Under {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("벤치를 입력하시오: ");
		int x = input.nextInt();
		System.out.print("스쿼트를 입력하시오: ");
		int y = input.nextInt();
		System.out.print("데드를 입력하시오: ");
		int z = input.nextInt();
			
		boolean result = (x + y + z) >= 500;
		System.out.println("입어도되나? " + result);
	}
}