//������ ��
//����
//N���� ���ڰ� ���� ���� �����ִ�. �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//�Է�
//ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٿ� ���� N���� ������� �־�����.
//
//���
//�Է����� �־��� ���� N���� ���� ����Ѵ�.
//
//���� �Է� 1 
//1
//1
//���� ��� 1 
//1
//���� �Է� 2 
//5
//54321
//���� ��� 2 
//15
//���� �Է� 3 
//25
//7000000000000000000000000
//���� ��� 3 
//7
//���� �Է� 4 
//11
//10987654321
//���� ��� 4 
//46

import java.util.Scanner;
public class Q11720 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		String input = scan.nextLine();
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += Character.getNumericValue(input.charAt(i)); // Character.getNumericValue(input.charAt(i)) -> (char) ���� int ������ ��ȯ
		}
		System.out.println(sum);
	}
}