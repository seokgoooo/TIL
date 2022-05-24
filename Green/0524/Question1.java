import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 8;
		int guess;
		int tries = 0;
		boolean on = true;
		
		while (on) {
			System.out.print("비밀번호를 맞춰보세요: ");
			guess = sc.nextInt();
			tries++;
			
			if (guess > answer) {
				System.out.println("제시한 정수가 높습니다.");
			}
			
			if (guess < answer) {
				System.out.println("제시한 정수가 낮습니다.");
			}
				
			if (guess == answer) {
				System.out.printf("정답! 축하합니다. 시도 횟수=%d \n", tries);
				on = false;
			}
			
			if (tries == 3) {
				System.out.println("기회가 끝났습니다.");
				on = false;
			}
		}
	}
}