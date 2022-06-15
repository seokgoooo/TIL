package bmi;

import java.util.Arrays;
import java.util.Scanner;

class MemberManage {
	Scanner scan = new Scanner(System.in);

	// 최대 10명 담을 수 있는 Member 클래스 배열
	Member[] members = new Member[10];

	// 회원번호 개념 (배열 index 세팅)
	int count = 0;

	public static void printMainMenu() {
		System.out.println("-----------------------");
		System.out.println("    회원 관리 프로그램");
		System.out.println("--1.--신규 회원 등록-------");
		System.out.println("--2.--기존 회원 삭제-------");
		System.out.println("--3.--기존 회원 변경-------");
		System.out.println("--4.--회원 목록 보기-------");
		System.out.println("--5.--회원 BMI 보기------");
		System.out.println("--6.--키(오름차순) 보기---");
		System.out.println("--7.--몸무게(오름차순) 보기");
		System.out.println("--0.--종-------료-------");
		System.out.println("-----------------------");
	}

	public void makeBase() {
		for (int i = 0; i < 10; i++) {
			members[i] = new Member("0", 999, 999);
		}
	}

	public void inputNewMember() {
		if (count < 10) {
			// 신규 회원 정보 입력
			Member newMember = new Member();
			newMember.setName(inputName());
			newMember.setHeight(inputHeight());
			newMember.setWeight(inputWeight());

			int flag = 0;

			// 중복 회원 찾는 검사
			// 중복 찾으면 flag = 1 로 변경해서 println 호출
			// 그리고 초기화
			for (int i = 0; i < 10; i++) {
				if (members[i].equals(newMember)) {
					flag = 1;
					newMember = new Member("0", 999, 999);
					break;
				}
			}

			// 중복 없으면 새로운 번호로 등록
			if (flag == 0) {
				members[count] = newMember;
				count++;
			} else {
				System.out.println("중복 회원 입니다");
			}
		} else {
			System.out.println("신규 회원 등록 불가");
		}
	}

	public String inputName() {
		System.out.print("이름: ");
		String name = scan.nextLine();
		return name;
	}

	public double inputHeight() {
		System.out.print("키(cm): ");
		double height = scan.nextDouble();
		return height;
	}

	public double inputWeight() {
		System.out.print("몸무게(kg): ");
		double weight = scan.nextDouble();
		scan.nextLine();					// 순서대로 nextLine nextDouble nextDouble 사용되기 때문에 마지막에 버퍼 초기화
		return weight;
	}

	public void deleteMember() {
		// TODO Auto-generated method stub
		return;
	}
	
	public void changeMember() {
		// TODO Auto-generated method stub
		
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
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 30
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 35) {
				System.out.println("중도비만");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 25
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 30) {
				System.out.println("경도비만");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 23
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 25) {
				System.out.println("과체중");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 18.5
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 23) {
				System.out.println("정상");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) > 0
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 18.5) {
				System.out.println("저체중");
				System.out.println(members[i].toString());
			} else {

			}
		}
	}

	public void printHeightSort() {
		Arrays.sort(members);
		for (int i = 0; i < count; i++) {
			System.out.println("이름= " + members[i].getName() + " 키(cm)= " + members[i].getHeight());
		}
	}

	public void printWeightSort() {
		Arrays.sort(members);
		for (int i = 0; i < count; i++) {
			System.out.println("이름= " + members[i].getName() + " 몸무게(kg)= " + members[i].getWeight());
		}
	}

}