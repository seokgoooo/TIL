class Car {
	private String color;
	private int speed;
	private int gear;
//	자동차의 시리얼 번호
	private int id;
	
	/*
	 * 실체화된 Car 객체의 개수를 위한 정적 변수
	 * static : 인스턴스 하나하나의 필드 값이 아니라 전체를 나타내주게 하는 변수
	 * 모든 객체에 공통인 변수
	 * 하나의 클래스에 하나만 존재한다.
	 * 웬만하면 private
	 * 
	 */	private static int numberOfCars = 0;
	
//	public static final int SHARE_NUMBER = 0;
//	final 얘는 값이 안 바뀌기 때문에 공유 목적으로는 부적합
	
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
//		자동차의 개수를 증가하고 id 번호를 할당한다.
		id = ++numberOfCars;
	}
	
//	정적 메소드
	public static int getNumberOfCars() {
		return numberOfCars;
	}
}

public class CarTest3 {
	public static void main(String[] args) {
		Car c1 = new Car("blue", 100, 1);
		Car c2 = new Car("white", 0, 1);
		int n = Car.getNumberOfCars();
		System.out.println("지금까지 생성된 자동차 수 = " + n);

	}

}
