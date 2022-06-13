package box;

public class ColorBox extends Box {
	String color;
	
	public ColorBox() {
		super(10, 10, 10);				// 자식 클래스는 반드시 부모 클래스의 기본 생성자가 필요하다~ 왜 why? 초기화가 부모 클래스 -> 자식 클래스 순서로 이루어짐
		this.color = null;
	}
	
	public String getColor() {
		return color;
	}
}
