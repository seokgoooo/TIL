package sec01.exam03;

public class VariableExchangeExample {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + ", y:" + y);
	
		int temp = x;	//���� x �� 3�� ���� temp�� ����
		x = y;			//���� y �� 5�� ���� x�� ����
		y = temp;		//���� temp �� 3�� ���� y�� ����
		System.out.println("x:" + x + ", y:" + y);
	}
}