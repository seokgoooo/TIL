package multi_abstract;

public abstract class MySubClass extends MyClass {

	@Override
	public void myMethod() {
		System.out.println("자식 클래스에서 구현되었습니다");
	}

	public abstract void myMethod2();
}