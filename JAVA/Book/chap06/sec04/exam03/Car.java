package sec04.exam03;

public class Car {
	// �ʵ�
	int gas;
	
	// ������
	
	// �޼ҵ�
	void setGas(int gas) {	// ���ϰ��� ���� �޼ҵ�� �Ű����� �޾Ƽ� gas �ʵ尪�� ����
		this.gas = gas;
	}
	
	boolean isLeftGas() {	// ���ϰ��� boolean�� �޼ҵ�� gas �ʵ尪�� 0�̸� false, �ƴϸ� true ����
		if(gas == 0) {
			System.out.println("gas�� �����ϴ�.");
			return false;
		}
		System.out.println("gas�� �ֽ��ϴ�.");
		return true;
	}
	
	void run() {	// ���ϰ��� ���� �޼ҵ�� gas �ʵ尪�� 0�̸� return������ �޼ҵ� ���� ����
		while(true) {
			if(gas > 0) {
				System.out.println("�޸��ϴ�.(gas�ܷ�:" + gas + ")");
				gas -= 1;
			}	else {
				System.out.println("����ϴ�.(gas�ܷ�:" + gas + ")");
				return;	//�޼ҵ� ���� ���� 
			}
		}
	}
}