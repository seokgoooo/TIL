package mybeans;

public class MyLogic {
	private MyBean mybean;

	public MyLogic(MyBean mybean) {
		this.mybean = mybean;
	}

	public void setMybean(MyBean mybean) {
		this.mybean = mybean;
	}

	public void someMethod() {
		System.out.println("���� �۾��� �����ϱ� ���� ��ü �������� �ʿ��մϴ�.");
		mybean.hello();
	}
}
