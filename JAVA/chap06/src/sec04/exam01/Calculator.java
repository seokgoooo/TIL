package sec04.exam01;
public class Calculator {
	// �ʵ�
	// ������ Constructor
	// �޼ҵ� Method
	void powerOn() {
		System.out.println("������ �մϴ�.");		
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("������ ���ϴ�");
	}
}