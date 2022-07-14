import kr.co.greenart.MyMath;
import kr.co.greenart.Person;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("이름", 15);
		System.out.println(p);
		System.out.println(MyMath.getZero());
		System.out.println(MyMath.sum(10, 20));
		
//		외부 클래스들을 Export 시킨 jar 를 Referenced Libraries 에 불러와주면 이 프로젝트에 포함된다.
//		의존성이 생긴다 라고 한다.
	}
}
