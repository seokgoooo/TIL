/*
 * �� �̻� �ڵ常���δ� �����ϱⰡ ��ƴ� �׸��� Outline ���� �����ؾ���
 * 
 * Ŭ������ ���Һ��� ����
 */
package bmi;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberManage run = new MemberManage();

		// Member �迭 �ʱ�ȭ
		run.makeBase();
		
		boolean on = true;
		while (on) {
			run.printMainMenu();
			switch (scan.nextInt()) {
			case 1:
				// �ߺ� ��� X (�̸�, Ű, ������ ������ ��)
				// ���ؿ� ���� ���踦 �ؼ� ����� ��������մϴ�.
				run.inputNewMember();
				break;
			case 2:
				// ���� ȸ�� ����
				run.deleteMember();
				break;
			case 3:
				// ���� ȸ�� ����
				run.changeMember();
				break;
			case 4:
				// ȸ�� ��� ���
				run.printMemberList();
				break;
			case 5:
				// BMI ���� ���� ���
				run.printBmi();
				break;
			case 6:
				// Ű(��������) ���� ���
				run.printHeightSort();
				break;
			case 7:
				// ������(��������) ���� ���
				run.printWeightSort();
				break;
			case 0:
				System.out.println("���α׷� ����");
				on = false;
				break;
			default:
				break;
			}
		}
	}
}