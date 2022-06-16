/*
 * 더 이상 코드만으로는 설명하기가 어렵다 그림과 Outline 으로 설명해야함
 * 
 * 클래스의 역할부터 설명
 */
package bmiMembership;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Manage run = new Manage();

		// Member 배열 초기화
		run.makeBase();
			
		boolean on = true;
		while (on) {
			run.printMainMenu();
			switch (scan.nextInt()) {
			case 1:
				// 중복 등록 X (이름, 키, 몸무게 동일할 때)
				// 기준에 따라 집계를 해서 목록을 보여줘야합니다.
				run.inputNewMember();
				break;
			case 2:
				// 기존 회원 삭제
				run.deleteMember();
				break;
			case 3:
				// 기존 회원 변경
				run.changeMember();
				break;
			case 4:
				// 회원 목록 출력
				run.printMemberList();
				break;
			case 5:
				// BMI 지수 조건 출력
				run.printBmi();
				break;
			case 6:
				// 키(오름차순) 정렬 출력
				run.printHeightSort();
				break;
			case 7:
				// 몸무게(오름차순) 정렬 출력
				run.printWeightSort();
				break;
			case 0:
				System.out.println("프로그램 종료");
				on = false;
				break;
			default:
				break;
			}
		}
	}
}