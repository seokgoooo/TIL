package sec01.exam06;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
//		Math.random()�� 0.0 ~ 1.0 �Ǽ��� ������.
		int time = (int) (Math.random() * 4) + 8;
		System.out.println("[���� �ð�: " + time + " ��]");
		
		switch(time){
		case 8:
			System.out.println("����մϴ�.");
		case 9:
			System.out.println("ȸ�Ǹ� �մϴ�.");
		case 10:
			System.out.println("������ ���ϴ�.");
		default:		//default�� ���������ϴ�.
			System.out.println("�ܱ��� �����ϴ�.");
		}
	}
}