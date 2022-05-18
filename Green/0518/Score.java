// 국어, 영어, 수학 점수를 정수로 입력받아 총합과 평균점수를 출력하는 프로그램
import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = input.nextInt();
		
		System.out.print("영어 점수 입력: ");
		int eng = input.nextInt();
		
		System.out.print("수학 점수 입력: ");
		int math = input.nextInt();
		
		int sum = kor + eng + math;
		int avg = sum / 3;
		System.out.println("점수 총합: " + sum);
		System.out.println("점수 평균: " + avg);
	}
}