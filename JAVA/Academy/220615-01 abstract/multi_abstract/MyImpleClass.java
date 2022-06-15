package multi_abstract;

// class Test extends MyImpleClass {}	MyImpleClass 는 종단클래스라 상속 불가능하다 (컴파일 에러)
public final class MyImpleClass extends MySubClass {
	// 더 이상 상속 시키고 싶지 않을 때 종단 클래스 (final) 을 붙여준다 (확장 불가능)
	// 메소드에도 적용 가능

	@Override
	public void myMethod() {
		System.out.println("새롭게 재정의");
	}

	@Override
	public void myMethod2() {
		System.out.println("마이메소드2 오버라이드 구현");
	}

	public static void main(String[] args) {
		MyClass m = new MyImpleClass();
//		추상 클래스    =     자식 클래스 ( 구현됨 )
		m.myMethod();
		
		MySubClass sub = (MySubClass) m;
		sub.myMethod();
		sub.myMethod2();
	}
}