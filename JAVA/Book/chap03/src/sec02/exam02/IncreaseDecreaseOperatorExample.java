package sec02.exam02;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int x = 10;
		int y =10;
		int z;
		
		System.out.println("----------------------------");
		x++;
		++x;
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
		y--;
		--y;
		System.out.println("y=" + y);
		
		System.out.println("----------------------------");
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
//		z = ++x + y++; �� ���̶� �Ʒ� ���̶� ���� ���ε� �Ʒ��� 3���̶� ��Ȯ�� �������� �� ���Ƽ� �Ʒ�ó�� ���°� �ٶ����ϴ�.
		++x;
		z = x + y;
		y++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}