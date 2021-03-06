public class Car {
	public int speed;
	int gear;
	private String color;
	
	// 첫 번째 생성자
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
	}
	
	// 색상만 주어진 생성자
	public Car(String c) {
		this(c, 0, 1);	// 첫 번째 생성자를 호출한다.
		System.out.println("초기화 과정 중~~");
	}
	
	// 접근(색상)
	public String getColor() {
		return color;
	}
	
	// 설정(색상)
	public boolean setColor(String c) {
		if (c != null) {
			color = c;
			return true;
		}
		return false;
	}
	
	// 접근(스피드)	// getter
	public int getSpeed() {
		return speed;
	}
	
	// 설정(스피드)	// setter
	public void setSpeed(int s) {
		speed = s;
	}
	
	// 접근(기어)
	public int getGear() {
		return gear;
	}
	
	// 설정(기어)
	public void setGear(int g) {
		gear = g;
	}
	
	// get set 등으로 생성자 쓰는 이유 : 객체 지향이라는 것은 객체의 행동으로 이루어 지는것으로 생각하기 때문이다.
}