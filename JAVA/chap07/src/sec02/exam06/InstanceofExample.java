package sec02.exam06;

public class InstanceofExample {
	public static void method1(Parent parent) {
		if (parent instanceof Child) {	// Child Ÿ������ ��ȯ �������� Ȯ��
			Child child = (Child) parent;
			System.out.println("method1 - Child�� ��ȯ ����");
		} else {
			System.out.println("method1 - Child�� ��ȯ���� ����");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;		// ClassCastException�� �߻��� ���ɼ� ����
		System.out.println("method2 - Child�� ��ȯ ����");
	}
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);			// Child ��ü�� �Ű������� ����
		method2(parentA);			// Child
		
		Parent parentB = new Parent();
		method1(parentB);			// Parent ��ü�� �Ű������� ����
		method2(parentB);			// Parent  // ���� �߻�
	}
}