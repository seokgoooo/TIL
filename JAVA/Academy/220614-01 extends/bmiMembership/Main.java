/*
 * 더 이상 코드만으로는 설명하기가 어렵다 그림과 Outline 으로 설명해야함
 * 
 * 클래스의 역할부터 설명
 */
package bmiMembership;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberManage run = new MemberManage();

		// 최대 10 명 담을 수 있는 Member 클래스 배열
		Member[] members = new Member[10];
		// Member 배열 초기화
		run.makeBase();
		
		boolean on = true;
		while (on) {
			run.printMainMenu();
			switch (scan.nextInt()) {
			case 1:
				// 중복 등록 X (이름, 키, 몸무게 동일할 때)
				// 기준에 따라 집계를 해서 목록을 보여줘야합니다.
				System.out.println("1번 출력");
				run.inputNewMember();
				break;
			case 2:
				run.changeMember();
				break;
			case 3:
				// 회원 목록 출력
				run.printMemberList();
				break;
			case 4:
				// BMI 지수 조건
				run.printBmi();
				break;
			case 5:
				run.printHeightSort();
				break;
			case 6:
//				run.printWeightSort();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			default:
				break;
			}
		}
	}
}