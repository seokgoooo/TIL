package classExample;
public class Car {
	private String number;
	private int year;
	private int price;
	private String color;
	private String type;

	// 캡슐화
	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	// 자동차의 시동을 거는 메소드
	// 화면에 부릉부릉이란 메시지만 출력하게 만들어보자
	void turnOn() {
		System.out.println("부릉부릉!");
	}

	// 자동차의 정보를 출력하는 메소드
	void print() {
		System.out.printf("차량번호: %s, 차종: %s\n", number, type);
		System.out.printf("연식: %d년 가격: %d원 색상: %s\n", year, price, color);
	}

	// 자동차의 가격을 비교하는 메소드
	void comparePrice(Car car) {
		if (price > car.price) {
			System.out.println("메소드를 실행하는 " + number + " 차량이 더 비쌉니다.");
		} else {
			System.out.println("파라미터인" + car.number + " 차량이 더 비쌉니다.");
		}
	}

	// Car 클래스 생성자
	// 1. 파라미터가 있는 생성자
	public Car(String number) {
		// 파라미터로 넘어온 number를 우리의 필드 number에 넣어보자!
		// 만약 필드와 파라미터의 이름이 같다면
		// 필드에 앞에 this. 을 붙여서
		// 이 메소드를 호출하는 객체의 필드라는 것을 입력하면 된다.
		this.number = number;
	}

	// 2. 파라미터가 없는 생성자
	public Car() {
		// 파라미터가 없는 생성자의 경우
		// 우리가 임의 값을 호출해주는 대신
		// 참조형 데이터타입의 필드에 대한
		// 생성자를 호출해 주는 것이 가장 좋은 방법이다!
		number = new String();
		color = new String();
		type = new String();
	}

	// toString() 재정의하기
	// toString()은
	// java.lang.Object에서
	// public String toString() 으로 적혀있다.
	// 우리가 오버라이드한다면 똑같이 선언해 주어야 한다!!!!

	public String toString() {
		// 여기서 필드 이름: 필드값 요런식으로 String을 만들어서 리턴해주면 된다.
		String returnValue = new String();
		returnValue += "차량 번호: " + number;
		returnValue += ", 차종: " + type;
		returnValue += ", 연식: " + year;
		returnValue += ", 색상: " + color;
		returnValue += ", 가격: " + price;
		return returnValue;
	}

	// equals 오버라이드
	public boolean equals(Object obj) {
		// "야 다각형이면 파라미터로 다 올 수 있어"
		// -> "그중에서 사각형만 나와봐"
		// -> "너네들 세부사항이 같니?"
		// -> "같으면 return true"

		// 먼저 Object obj가 이 클래스(Car)의 객체인지 확인한다
		// 만약 obj가 Car 클래스의 객체이면 이 메소드 내부에서
		// 임시로 Car c 라고 호칭할 수 있게 형변환해준다.
		// 그 후에 이 메소드를 실행하는 객체의 필드와 c의 필드를 비교해서
		// 차량 번호와 차종이 같으면 true를 리턴한다.

		// obj가 Car의 객체인지 확인할 때에는
		// instanceof 라는 키워드를 사용하면 된다.

		if (obj instanceof Car) {
			// 만약 obj가 Car의 객체라면 이 조건식이 true가 나온다.
			// 그렇다면 우리가 형변환을 통해 임시로 Car c라는 객체로 만들어줄 수 있다.
			Car car = (Car) obj;
			// 그렇게 한 후에 c의 필드와 이 메소드를 실행하는 객체의 필드의 값을 비교하면 된다.
			if (number.equals(car.number) && type.equals(car.type)) {
				return true;
			}
		}
		return false;
	}
}

class CarEx {
	public static void main(String[] args) {
		// 객체를 만들어봅시다
		// 객체는
		// 클래스이름 객체이름 = 뉴 클래스이름();
		// 로 만들어줄 수 있다.
		Car car = new Car();

		// 객체의 필드나 메소드를 접근할 때에는
		// 객체이름.필드 혹은 객체이름.메소드로 접근 가능하다.
		// 객체이름.필드 는 하나의 변수처럼 우리가 쓸 수 있다.
//		c.number = "00가 0000";
//		c.year = 2020;
//		c.type = "페라리";
//		c.color = "빨간색";
//		c.price = 10000;

		// 캡슐화 된 필드에 값을 넣어줄때에는
		// 객체의 셋터 메소드를 호출해 주면 된다.
		car.setNumber("00가 0000");
		car.setYear(2020);
		car.setType("페라리");
		car.setColor("빨간색");
		car.setPrice(10000);

		// System.out.println("이차의 가격: "+c.price+" 만원");

		// 캡슐화된 필드의 값을 호출할 때에는
		// 객체의 겟터 메소드를 호출해주면 된다.
		System.out.println("이차의 가격: " + car.getPrice() + " 만원");

		car.turnOn();
		car.print();

		Car c2 = new Car();
//		c2.number = "99하 9999";
//		c2.year = 2020;
//		c2.type = "K5";
//		c2.color = "흰색";
//		c2.price = 3000;

		c2.setNumber("99하 9999");
		c2.setYear(2020);
		c2.setType("K5");
		c2.setColor("흰색");
		c2.setPrice(3000);

		c2.turnOn();
		c2.print();

		car.comparePrice(c2);
		c2.comparePrice(car);

		Car c3 = new Car();
		c3.print();

		c3.setNumber("99하 9999");
		c3.setYear(2020);
		c3.setType("K5");
		c3.setColor("흰색");
		c3.setPrice(3000);

		System.out.println(car);
		System.out.println(c2);
		System.out.println(c3);

		// System.out.println() 에
		// 객체를 파라미터로 넘기면
		// 해당 객체의 toString() 메소드의 string 결과값을
		// 화면에 출력한다.

		// c2 객체와 c3객체를 비교해보자
		System.out.println("c2.equals(c3): " + c2.equals(c3));

		// java.lang.Object의 equals() 메소드는 다음과 같이
		// 구현되어있다.
		// public boolean equals(Object obj){
		// return this == obj;
		// }

		// 위 코드에서는 우리가 생각한 값 비교 대신 주소값 비교를 하기 때문에
		// 우리가 equals()메소드를 오버라이드 하지 않고 사용하면
		// 정확한 값을 얻을 수 없다!
	}
}