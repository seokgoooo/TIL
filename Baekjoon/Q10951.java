//����	EOF
//�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//�Է�
//�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.
//�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)
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
//
//���� ��� 1 
//2
//5
//7
//17
//7
import java.util.Scanner;
//EOF�� End Of File�� ����. ������ �ҽ��κ��� �� �̻� ���� �� �ִ� �����Ͱ� ���ٴ� ��
public class Q10951 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a + b);
		}
	}
}