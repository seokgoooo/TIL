// 학생 : 이름, 나이
// 영국학생 : 인사할 수 있음 (Hello)
// 한국학생 : 인사할 수 있음 (안녕)
// 미국인 : 인사할 수 있음 (Wassup)

package student;

public interface Helloable {
	void hello();
}

class Student {
	private String name;
	private int age;
}

class Korean extends Student implements Helloable {
	@Override
	public void hello() {
		System.out.println("안녕");
	}
}

class England extends Student implements Helloable {
	@Override
	public void hello() {
		System.out.println("hello");
	}
}

class American implements Helloable {
	@Override
	public void hello() {
		System.out.println("Wassup");
	}
}