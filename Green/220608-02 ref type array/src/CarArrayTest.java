class Car {
	public int speed;
	public int gear;
	public String color;

	public Car() {
		speed = 0;
		gear = 1;
		color = "red";
	}

	public void speedUp() {
		speed += 10;
	}

	public String toString() {	// 객체의 상태를 문자열로 반환하는 메소드
		return "속도: " + speed + " 기어: " + gear + " 색상: " + color;
	}
}

public class CarArrayTest {
	public static void main(String[] args) {
		final int NUM_CARS = 5;
		Car[] cars = new Car[NUM_CARS];
		// Car car 1개에 5번 반복되는 경우.
		Car c = new Car();
		
		for (int i = 0; i < cars.length; i++) {
			cars[i] = c;
		}
		
		for (Car car : cars) {
			car.speedUp();
		}
		
		for (Car car : cars) {
			System.out.println(car);
		}
		
		// Car car 5개에 반복되는 경우.
//		for (int i = 0; i < cars.length; i++) {
//			cars[i] = new Car();
//		}
//
//		for (int i = 0; i < cars.length; i++) {
//			cars[i].speedUp();
//		}
//		
//		for (Car c : cars) {
//			c.speedUp();
//		}
//		
//		for (int i = 0; i < cars.length; i++) {
//			System.out.println(cars[i]);
//		}
//		
//		for (Car c : cars) {
//			System.out.println(c);
//		}
	}
}