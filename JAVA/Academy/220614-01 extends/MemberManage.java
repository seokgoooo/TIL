package membership;

import java.util.Scanner;

public class MemberManage {
	Scanner scan = new Scanner(System.in);
	Member[] manage = new Member[10];
	MemberManage run = new MemberManage();
	
	public MemberManage() {
	}

	public MemberManage(Member... manage) {
		this.manage = manage;
	}

	public void inputMemberMessage() {
		System.out.println("신규 등록은 1");
		System.out.println("아니면 아무거나 누르세요");
	}

	public boolean membershipCheck(int inputCheck) {
		if (inputCheck == 1) {
			if (manage[0] == null) {
				return true;
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i != j) {
						if (!manage[i].equals(manage[j])) {
							return true;
						} else
							return false;
					}
				}
			}
		} else
			return false;
		return false;
	}

	public String inputName() {
		scan.nextLine();
		System.out.print("이름: ");
		String name = scan.nextLine();
		return name;
	}

	public double inputHeight() {
		System.out.print("키(m): ");
		double height = scan.nextDouble();
		return height;
	}

	public double inputWeight() {
		System.out.print("몸무게(kg): ");
		double weight = scan.nextDouble();
		return weight;
	}

	public Member membershipInput() {
		inputMemberMessage();
		boolean membership = membershipCheck(scan.nextInt());
		if (membership == true) {
			return new MemberManage(run.inputName(), run.inputHeight(), run.inputWeight());
		} else {
			System.out.println("다시 실행해주세요");
			return null;
		}
	}

	public void run() {
		boolean on = true;
		while (on) {
			membershipInput();
		}
	}
}