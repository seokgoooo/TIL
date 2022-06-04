package sec02.exam06;

public class InstanceofExample {
	public static void method1(Parent parent) {
		if (parent instanceof Child) {	// Child 타입으로 변환 가능한지 확인
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;		// ClassCastException이 발생할 가능성 있음
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);			// Child 객체를 매개값으로 전달
		method2(parentA);			// Child
		
		Parent parentB = new Parent();
		method1(parentB);			// Parent 객체를 매개값으로 전달
		method2(parentB);			// Parent  // 예외 발생
	}
}