import java.util.Arrays;
import java.util.Scanner;

//사용자에게 5번의 정수를 입력받아 최근 입력한 순(역순)으로 출력하기
//예) 10 20 30 40 50 -> 50 40 30 20 10

//사용자가 0이하의 정수를 입력할 때까지 반복하여 입력
//최근 5개를 출력
//10 20 30 40 50 60 70 80 90 100 -1 -> 100 90 80 70 60
public class Main5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//
//		int[] reverse = new int[5]; 
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.print("정수 입력: ");
//			reverse[i] = scan.nextInt();
//		}
//		
//		for (int i = 4; i >= 0; i--) {
//			System.out.println(reverse[i]);
//		}
		
		int i = 0;
		
		while (true) {
			int[] zero = new int[5];
			System.out.print("정수 입력: ");
			zero[i] = scan.nextInt();
			i++;
			
			if (zero[i] <= 0) {
				System.out.println(Arrays.toString(zero));
			
				break;
			}
		}
			
			
					
	}
}