class Car {
	// 필드 선언
	private int speed; // 속도

	// 중복 메소드: 정수 버전
	public void setSpeed(int s) {
		speed = s;
		System.out.println("정수 버전 호출");
	}

	// 중복 메소드: 실수 버전
	public void setSpeed(double s) {
		speed =  s;
		System.out.println("실수 버전 호출");
	}
}

public class CarTest1 {
	public static void main(String[] args) {
		Car myCar = new Car(); // 첫번째 객체 생성

//		myCar.setSpeed(100); // 정수 버전 메소드 호출
//		myCar.setSpeed(79.2); // 실수 버전 메소드 호출
		
//		myCar.setSpeed(1000L);	long으로 넘어감
//		myCar.setSpeed('A'); 	아스키코드로 전환되서 int로 받아들임
//		myCar.setSpeed("A");	얘는 문자열
	}
}
