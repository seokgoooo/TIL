package sec02.exam05;

public class ChildExample {
	public static void main(String[] args) {
		Parent parent = new Child();		// �ڵ� Ÿ�� ��ȯ
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		/*
		 * (�Ұ���)
		   parent.field2 = "data2";
		   parent.method3();
		   
		 */
		
		Child child = (Child) parent;		// ���� Ÿ�� ��ȯ
		child.field2 = "yyy";				// (����)
		child.method3();
	}
}