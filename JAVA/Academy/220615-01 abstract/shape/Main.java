package shape;
//삼각형
//중심점(x, y)
//밑변
//높이

//넓이를 구해서 알려줄 수 있음.

//직사각형
//중심점(x, y)
//가로
//세로

//넓이를 구해서 알려줄 수 있음.

//원
//중심점(x, y)
//반지름

//넓이를 구해서 알려줄 수 있음.

public class Main {
	public static void main(String[] args) {
// 		추상 클래스는 구체적이지 않은(미완성인) 클래스라 객체 생성이 불가능하다
//		공통점을 찾아서 만든 추상 클래스를 상속받아 구체적으로 각각의 클래스를 완성해줘야 한다
//		=> ( abstract 클래스를 상속하는 클래스에서 해당 abstract 메소드를 구현해야만 한다 )
		
//		추상 클래스를 사용하는 이유는 책임을 강제하기 위해
//		상속받는 클래스는 무조건 재정의를 해야한다.
		
//		Shape s1 = new Shape();
//		Shape s2 = new Shape(10, 20);
		
		Triangle t = new Triangle(0, 0, 5, 5);
		System.out.println(t.getArea());
		
//		추상 클래스가 하나의 타입으로 사용되는 예
//		Shape 클래스가 Triangle 타입으로 사용됨
		Shape s = t;
		System.out.println(s.getArea());
		
		Rectangle r = new Rectangle(0, 0, 5, 5);
		System.out.println(r.getArea());
		
		Shape rr = new Rectangle(0, 0, 10, 10);
		System.out.println(rr.getArea());
		
		Circle c = new Circle(0, 0, 5);
		System.out.println(c.getArea());
		
		Shape cc = new Circle(0, 0, 7);
		System.out.println(cc.getArea());
		
	}
}