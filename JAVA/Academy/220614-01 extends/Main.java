package membership;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberManage run = new MemberManage();
		Member[] manage = new Member[10];

		System.out.println("몇 명 입력하실건가요~");
		System.out.println("(10명까지 입력 가능)");
		int people = scan.nextInt();
		for (int i = 0; i < people; i++) {
			manage[i] = new Member(run.inputName(), run.inputHeight(), run.inputWeight());
		}
	}
}