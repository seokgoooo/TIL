package sec06.exam05.package2;

import sec06.exam05.package1.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1;	default �ʵ� ���� �Ұ�
//		a.field3 = 1;	private �ʵ� ���� �Ұ�
		
		a.method1();
//		a.method2();	default �޼ҵ� ���� �Ұ�
//		a.method3();	private �޼ҵ� ���� �Ұ�
	}
}
