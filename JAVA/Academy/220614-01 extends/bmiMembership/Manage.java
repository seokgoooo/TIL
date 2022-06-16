package bmiMembership;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class Manage {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	// 최대 10명 담을 수 있는 Member 클래스 배열
	Member[] members = new Member[10];
		
	public static void printMainMenu() {
		// 메인메뉴 출력
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
		// 배열 초기화
		for (int i = 0; i < 10; i++) {
//			members[i] = new Member(false, "0", 999, 999);
			// test 용 random 값
			members[i] = new Member(ran.nextBoolean(), "이름", ran.nextInt(200), ran.nextInt(150));
		}
	}

	public void inputNewMember() {
		
		if (!members[9].isMembership()) {
			// 신규 회원 정보 입력
			Member newMember = new Member();
			newMember.setMembership(true);
			newMember.setName(inputName());
			newMember.setHeight(inputHeight());
			newMember.setWeight(inputWeight());

			for (int i = 0; i < 10; i++) {
				// 중복 찾기
				if (members[i].equals(newMember)) {
					newMember = new Member(false, "0", -1, -1);
					System.out.println("중복 회원 입니다");
					break;
				}
				
				// 중복이 아니고 등록 상태가 아니면
				else if (!members[i].isMembership()) {
					members[i] = newMember;
					break;
				}
			}
		} else {
			System.out.println("신규 회원 등록 불가");
		}
	}

	public String inputName() {
		// 이름 입력
		System.out.print("이름: ");
		String name = scan.nextLine();
		return name;
	}

	public double inputHeight() {
		// 키 입력
		System.out.print("키(cm): ");
		double height = scan.nextDouble();
		return height;
	}

	public double inputWeight() {
		// 몸무게 입력
		System.out.print("몸무게(kg): ");
		double weight = scan.nextDouble();
		scan.nextLine(); // 순서대로 nextLine nextDouble nextDouble 사용되기 때문에 마지막에 버퍼 초기화
		return weight;
	}

	public void deleteMember() {
		// 회원 삭제
		return;
	}

	public void changeMember() {
		// 회원 변경

	}

	public void printMemberList() {
		// 회원 목록 출력
		for (int i = 0; i < 10; i++) {
			if (members[i].isMembership())
				System.out.println("번호: " + i + " " + members[i].toString());
		}
	}

	public void printBmi() {
		// Bmi 출력
		for (int i = 0; i < 10; i++) {
			if (members[i].isMembership()) {
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
	}

	public void printHeightSort() {
		// 키 오름차순 정렬
		Arrays.sort(members);
		for (int i = 0; i < 10; i++) {
			if (members[i].isMembership())
				System.out.println("이름= " + members[i].getName() + " 키(cm)= " + members[i].getHeight());
		}
	}

//	지역 클래스 ( 자바는 모든 것이 클래스다. 만들다보면 클래스를 계속 따로 만들어줘야 한다.
//	관리하기가 너무나도 귀찮기 때문에 그래서 지엽적인, 일회용 클래스 같은 경우
//	클래스 안에서 선언해서 변수 이름을 지어주기도 하고 익명으로 쓸수도 있다. )
//	보통 추상적인 행동이 정의된 interface 나 abstract 둘의 UpCasting 을 이용한 개념
	Comparator<Member> weight = new Comparator<Member>() {
		@Override
		public int compare(Member o1, Member o2) {
			return (int) (o1.getWeight() - o2.getWeight());
		}
	};
	
//	이렇게 참조 변수 안주고 쓸수도 있는데
//	이렇게 되면 완전 일회용이다 (저장 해놓는 곳이 없기 때문에)
//	new Comparator<Member>() {
//		@Override
//		public int compare(Member o1, Member o2) {
//			return (int) (o1.getWeight() - o2.getWeight());
//		}
//	};
	
	public void printWeightSort() {
		// 몸무게 오름차순 정렬
		// sort 메소드에 ( 매개변수 2개 들어가는게 있다 )
		// (객체, 객체) 넣어주면 
		Arrays.sort(members, weight);
		for (int i = 0; i < 10; i++) {
			if (members[i].isMembership())
				System.out.println("이름= " + members[i].getName() + " 몸무게(kg)= " + members[i].getWeight());
		}
	}
	
	public void printNameSort() {
		// 이름 오름차순 정렬
		Arrays.sort(members, new NameComparator());
		for (int i = 0; i < 10; i++) {
			if (members[i].isMembership())
				System.out.println("이름= " + members[i].getName() + " 이름= " + members[i].getName());
		}
	}
}