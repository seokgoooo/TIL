package sec04.verify.exam03;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[�ʼ� ���� �Է�]");
		
		System.out.print("1. �̸�: ");
		String name = scanner.nextLine();
		
		System.out.print("2. �ֹι�ȣ �� 6�ڸ�: ");
		String ssn = scanner.nextLine();
		
		System.out.print("3. ��ȭ��ȣ: ");
		String tel = scanner.nextLine();
		
		System.out.println();
		
		System.out.println("[�Էµ� ����]");
		System.out.println("1. �̸�: " + name);
		System.out.println("2. �ֹι�ȣ �� 6�ڸ�: " + ssn);
		System.out.println("3. ��ȭ��ȣ: " + tel);
	}
}
