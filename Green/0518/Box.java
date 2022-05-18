// 밑변과 높이를 정수로 입력 사각형의 둘레와 넓이를 출력
// 둘레 : (밑변 + 높이) *2 . 넓이 (밑변 * 높이)
import java.util.Scanner;

public class Box {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;
		int y;
		int round;
		int area;
		
		System.out.print("밑변을 입력하시오: ");
		x = input.nextInt();
		
		System.out.print("높이을 입력하시오: ");
		y = input.nextInt();
		
		round = (x + y) * 2;
		area = x * y;
		
		System.out.println("사각형의 둘레 : " + round);
		System.out.println("사각형의 넓이 : " + area);	
	}
}