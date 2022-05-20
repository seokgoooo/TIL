// 정수를 입력받아 60점 이상이면 합격 아니면 불합격 출력과 함께 부족한 점수도 같이 출력
import java.util.Scanner;

public class SixtyScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력하세요. ");
		int score = sc.nextInt();
		
		if (score >= 60) {
			System.out.println("합격");
		}
		else {
		System.out.println("불합격");
		System.out.printf("부족한 점수: %d", 60 - score);
		}
	}
}