class Car {
	// 필드 정의
	String color;	// 색상
	int speed;		// 현재 속도
	int gear;		// 현재 기어
	void print() {
		System.out.println("(" + color + ", " + speed + ", " + gear + ")");
	}
}
public class CarTest {
	public static void main(String[] args) {
		Car myCar = new Car();		// 객체 생성
		myCar.color = "red";		// 객체의 필드 변경
		myCar.speed = 0;
		myCar.gear = 1;
		myCar.print();				// 객체의 메소드 호출
		
		// 색상:blue 속도:60 기어:3
		Car yourCar = new Car();
		yourCar.color = "blue";
		yourCar.speed = 60;
		yourCar.gear = 3;
		yourCar.print();
		
	}
}