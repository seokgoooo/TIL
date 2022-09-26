//	추상 클래스 사용 목적 : 확장. 관련 패턴 -> 템플릿메소드(Template Method) 패턴
//	추상 클래스를 활용하여 변하지 않는 기능은 추상 클래스에 구현하고
//	자주 변경되거나 확장할 수 있는 기능은 서브 클래스(추상 클래스를 상속하는 클래스)에 정의한다.
//	추상 클래스 내부에 필드나 메소드를 직접 정의하여 '비슷한 코드의 반복을 줄이고'
//	일부 메소드의 구현을 서브 클래스에 위임하여 '기능의 확장'을 추구하는 디자인 패턴.
public abstract class Human {
	public abstract void sleep();

	public abstract int food();
}
