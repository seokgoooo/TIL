package bmi;

import java.util.Arrays;
import java.util.Scanner;

class MemberManage {
	Scanner scan = new Scanner(System.in);

	// �ִ� 10�� ���� �� �ִ� Member Ŭ���� �迭
	Member[] members = new Member[10];

	// ȸ����ȣ ���� (�迭 index ����)
	int count = 0;

	public static void printMainMenu() {
		System.out.println("-----------------------");
		System.out.println("    ȸ�� ���� ���α׷�");
		System.out.println("--1.--�ű� ȸ�� ���-------");
		System.out.println("--2.--���� ȸ�� ����-------");
		System.out.println("--3.--���� ȸ�� ����-------");
		System.out.println("--4.--ȸ�� ��� ����-------");
		System.out.println("--5.--ȸ�� BMI ����------");
		System.out.println("--6.--Ű(��������) ����---");
		System.out.println("--7.--������(��������) ����");
		System.out.println("--0.--��-------��-------");
		System.out.println("-----------------------");
	}

	public void makeBase() {
		for (int i = 0; i < 10; i++) {
			members[i] = new Member("0", 999, 999);
		}
	}

	public void inputNewMember() {
		if (count < 10) {
			// �ű� ȸ�� ���� �Է�
			Member newMember = new Member();
			newMember.setName(inputName());
			newMember.setHeight(inputHeight());
			newMember.setWeight(inputWeight());

			int flag = 0;

			// �ߺ� ȸ�� ã�� �˻�
			// �ߺ� ã���� flag = 1 �� �����ؼ� println ȣ��
			// �׸��� �ʱ�ȭ
			for (int i = 0; i < 10; i++) {
				if (members[i].equals(newMember)) {
					flag = 1;
					newMember = new Member("0", 999, 999);
					break;
				}
			}

			// �ߺ� ������ ���ο� ��ȣ�� ���
			if (flag == 0) {
				members[count] = newMember;
				count++;
			} else {
				System.out.println("�ߺ� ȸ�� �Դϴ�");
			}
		} else {
			System.out.println("�ű� ȸ�� ��� �Ұ�");
		}
	}

	public String inputName() {
		System.out.print("�̸�: ");
		String name = scan.nextLine();
		return name;
	}

	public double inputHeight() {
		System.out.print("Ű(cm): ");
		double height = scan.nextDouble();
		return height;
	}

	public double inputWeight() {
		System.out.print("������(kg): ");
		double weight = scan.nextDouble();
		scan.nextLine();					// ������� nextLine nextDouble nextDouble ���Ǳ� ������ �������� ���� �ʱ�ȭ
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
				System.out.println("����");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 30
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 35) {
				System.out.println("�ߵ���");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 25
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 30) {
				System.out.println("�浵��");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 23
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 25) {
				System.out.println("��ü��");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) >= 18.5
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 23) {
				System.out.println("����");
				System.out.println(members[i].toString());
			}
			if (members[i].getBmi(members[i].getHeight(), members[i].getWeight()) > 0
					&& members[i].getBmi(members[i].getHeight(), members[i].getWeight()) < 18.5) {
				System.out.println("��ü��");
				System.out.println(members[i].toString());
			} else {

			}
		}
	}

	public void printHeightSort() {
		Arrays.sort(members);
		for (int i = 0; i < count; i++) {
			System.out.println("�̸�= " + members[i].getName() + " Ű(cm)= " + members[i].getHeight());
		}
	}

	public void printWeightSort() {
		Arrays.sort(members);
		for (int i = 0; i < count; i++) {
			System.out.println("�̸�= " + members[i].getName() + " ������(kg)= " + members[i].getWeight());
		}
	}

}