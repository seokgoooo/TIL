//����
//�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//�Է�
//�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.
//�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)
//�Է��� ���������� 0 �� ���� ���´�.
//
//���
//�� �׽�Ʈ ���̽����� A+B�� ����Ѵ�.
//
//���� �Է� 1 
//1 1
//2 3
//3 4
//9 8
//5 2
//0 0

//���� ��� 1 
//2
//5
//7
//17
//7
import java.util.Scanner;
public class Q10952 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean on = true;
		while (on) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if (a == 0 & b == 0) {
				on = false;
				break;
			}
			System.out.println(a + b);
		}
	}
}