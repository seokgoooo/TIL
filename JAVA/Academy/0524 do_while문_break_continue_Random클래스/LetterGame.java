import java.util.Scanner;
import java.util.Random;

public class LetterGame {
	public static void main(String[] args) {
		Random random = new Random();
		int answer = random.nextInt(100);
		int guess;
		int tries = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("정답을 추측하여 보시오: ");
			guess = sc.nextInt();
			tries++;
			
			if (guess > answer) {
				System.out.println("제시한 정수가 높습니다.");
			}
			
			if (guess < answer) {
				System.out.println("제시한 정수가 낮습니다.");
			}
		} while (guess != answer);
		
		System.out.printf("축하합니다. 시도 횟수=%d \n", tries);
	}
}