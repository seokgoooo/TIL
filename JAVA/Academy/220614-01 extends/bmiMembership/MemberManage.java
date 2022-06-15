package bmiMembership;

import java.util.Arrays;
import java.util.Scanner;

class MemberManage implements Comparable<Member> {
	Scanner scan = new Scanner(System.in);

	// 최대 10명 담을 수 있는 Member 클래스 배열
	Member[] members = new Member[10];

	// 회원번호 개념 (배열 index 세팅)
	int count = 0;

	public static void printMainMenu() {
		System.out.println("-----------------------");
		System.out.println("    회원 관리 프로그램");
		System.out.println("--1.--신규 회원 등록-------");
		System.out.println("--2.--기존 회원 등록-------");
		System.out.println("--3.--회원 목록 보기-------");
		System.out.println("--4.--회원 BMI 보기------");
		System.out.println("--5.--키(오름차순) 보기---");
		System.out.println("--6.--몸무게(오름차순) 보기");
		System.out.println("--0.--종-------료-------");
		System.out.println("-----------------------");
	}

	public void makeBase() {
		for (int i = 0; i < 10; i++) {
			members[i] = new Member("0", 0, 0);
		}
	}

	public void inputNewMember() {
		if (count < 10) {
			for (int i = 0; i < 10; i++) {
				if (count == 0) {
					members[0] = new Member(inputName(), inputHeight(), inputWeight());
					count++;
					break;
				} else if (!members[count].equals(members[i])) {
					members[count] = new Member(inputName(), inputHeight(), inputWeight());
					count++;
					break;
				} else {
					members[count] = new Member("0", 0, 0);
					break;
				}
			}
		}
	}

	public String inputName() {
		System.out.print("이름: ");
		scan.nextLine();
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

	public void changeMember() {
		// TODO Auto-generated method stub
		return;
	}

	public void printMemberList() {
		for (int i = 0; i < count; i++) {
			System.out.println(members[i].toString());
		}
	}

	public void printBmi() {
		for (int i = 0; i < count; i++) {
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 35) {
				System.out.println("고도비만");
				System.out.println(members.toString());
			} else if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 30
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 35) {
				System.out.println("중도비만");
			} else if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 25
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 30) {
				System.out.println("경도비만");
			} else if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 23
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 25) {
				System.out.println("과체중");
			} else if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 18.5
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 23) {
				System.out.println("정상");
			} else if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) > 0
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 18.5) {
				System.out.println("저체중");
			} else {

			}
		}
	}

	@Override
	public int compareTo(Member obj) {
		Member other = obj;
		if (obj.getHeight() < other.getHeight())
			return -1;
		else if (obj.getHeight() > other.getHeight())
			return 1;
		else
			return 0;
	}

	public void printHeightSort() {
		Arrays.sort(members);
		for (int i = 0; i < count; i++) {
			System.out.println("이름= " + members[i].getName() + "키= " + members[i].getHeight());
		}
	}

//	public int compare(Member members) {
//		Member other = members;
//		return (int) (members.getWeight() - other.getWeight());
//	}
//
//	public void printWeightSort() {
//		Arrays.sort(members);
//		for (Member m : members)
//			System.out.println("이름= " + m.getName() + "몸무게= " + m.getWeight());
//	}
}