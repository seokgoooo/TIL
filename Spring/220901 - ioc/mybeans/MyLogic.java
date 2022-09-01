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
		System.out.println("다음 작업을 수행하기 위해 객체 의존성이 필요합니다.");
		mybean.hello();
	}
}
