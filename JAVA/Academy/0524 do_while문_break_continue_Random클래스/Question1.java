// 사용자한테 문자열 비밀번호 물어보고 동일할 경우 통과
// 최대 3번의 기회를 줌

import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer = "asdf";
		String guess;
		int tries = 0;
		boolean on = true;
		
		while (on) {
			System.out.print("비밀번호를 맞춰보세요: ");
			guess = sc.nextLine();
			tries++;
			
			if (guess.equals(answer)) {
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