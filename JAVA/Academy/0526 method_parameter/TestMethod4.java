import java.util.Scanner;
public class TestMethod4 {
	public static boolean between(int number) {
		if (number >= 1 && number <= 100) {
			return true;
		} else {
			return false;
		}
	}
	
	// 사용자가 국어, 영어, 수학 점수를 입력을 하는데 (사용자 입력값은 1 ~ 100사이여야함.)
	// 입력한 점수와, 점수 합을 출력해보세요~~~~~~~~
	public static void main(String[] args) {
		// 스캐너 선언 초기화
		Scanner scanner = new Scanner(System.in);
		int kor;
		int eng;
		int math;
		do {
			// 국어 점수 입력받기
			System.out.println("국어 점수?");
			kor = scanner.nextInt();
			// 국어 점수 확인하기
		} while ( !(between(kor)) ); // 1. 범위가 맞으면 다음, 2. 틀리면 다시 입력.
		
		do {
			System.out.println("영어 점수?");
			eng = scanner.nextInt();
		} while ( !(between(eng)) );

		do {
			System.out.println("수학 점수?");
			math = scanner.nextInt();
		} while ( !(between(math)) );
		
		// 합 구하기 (미리 구해놨음~~)
		int sum = kor + eng + math;
		// 국어영어수학 점수 출력하기
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		// 합 출력하기
		System.out.println("총합: " + sum);
		
		
		
		
		
		
		
		
		// System.out.println(between(150));
		// System.out.println(between(50));
		// System.out.println(between(-50));
		// System.out.println(between(100));
	}
}