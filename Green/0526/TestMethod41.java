import java.util.Scanner;
public class TestMethod41 {
	// 사용자로부터 국어, 수학, 영어 점수 입력을 받아 (1 ~ 100 사이의 수) 입력한 정수와 정수의 합 출력
	public static boolean getIf(int a) {
		if (a >= 1 && a <= 100) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void getScore() {
		Scanner sc = new Scanner(System.in);
		int kor;
		int eng;
		int math;
		do {
			System.out.print("국어 점수 입력 : ");
			kor = sc.nextInt();
		} while ( !(getIf(kor)) );
		
		do {
			System.out.print("수학 점수 입력 : ");
			math = sc.nextInt();
		} while ( !(getIf(math)) );
		
		do {
			System.out.print("영어 점수 입력 : ");
			eng = sc.nextInt();
		} while ( !(getIf(eng)) );
		
		int sum = kor + math + eng;
		
		System.out.println("국어 점수 : " + kor);
		System.out.println("수학 점수 : " + math);
		System.out.println("영어 점수 : " + eng);
		System.out.println("총합 : " + sum);
		
	}
	
	public static void main(String[] args) {
		getScore();
	}
}