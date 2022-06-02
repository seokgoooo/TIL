public class Car {
	private String number;
	private int year;
	private int price;
	private String color;
	private String type;
	
	//캡슐화
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
	
	//자동차의 시동을 거는 메소드
	//화면에 부릉부릉이란 메시지만 출력하게 만들어보자
	void turnOn(){
		System.out.println("부릉부릉!");
	}
	
	//자동차의 정보를 출력하는 메소드
	void print() {
		System.out.printf("차량번호: %s, 차종: %s\n", number, type);
		System.out.printf("연식: %d년 가격: %d원 색상: %s\n", year, price, color);
	}
	
	//자동차의 가격을 비교하는 메소드
	void comparePrice(Car c) {
		if(price > c.price) {
			System.out.println("메소드를 실행하는 "+number+" 차량이 더 비쌉니다.");
		}else {
			System.out.println("파라미터인"+c.number + " 차량이 더 비쌉니다.");
		}
	}
	
	// Car 클래스 생성자
	// 1. 파라미터가 있는 생성자
	public Car(String number) {
		//파라미터로 넘어온 number를 우리의 필드 number에 넣어보자!
		//만약 필드와 파라미터의 이름이 같다면
		//필드에 앞에 this. 을 붙여서
		//이 메소드를 호출하는 객체의 필드라는 것을 입력하면 된다.
		this.number = number;
	}
	
	// 2. 파라미터가 없는 생성자
	public Car() {
		//파라미터가 없는 생성자의 경우
		//우리가 임의 값을 호출해주는 대신
		//참조형 데이터타입의 필드에 대한
		//생성자를 호출해 주는 것이 가장 좋은 방법이다!
		
		number = new String();
		color = new String();
		type = new String();
	}
	
	
	
	
	//toString() 재정의하기
	//toString()은
	//java.lang.Object에서
	//public String toString() 으로 적혀있다.
	//우리가 오버라이드한다면 똑같이 선언해 주어야 한다!!!!
	
	public String toString() {
		//여기서 필드 이름: 필드값 요런식으로 String을 만들어서 리턴해주면 된다.
		String returnValue = new String();
		returnValue += "차량 번호: " + number;
		returnValue += ", 차종: "+type;
		returnValue += ", 연식: "+year;
		returnValue += ", 색상: "+color;
		returnValue += ", 가격: "+price;
		
		return returnValue;
		
	}
	
	//equals 오버라이드
	public boolean equals(Object obj) {
		
		//"야 다각형이면 파라미터로 다 올 수 있어"
		//-> "그중에서 사각형만 나와봐"
		//-> "너네들 세부사항이 같니?"
		//-> "같으면 return true"
		
		//먼저 Object obj가 이 클래스(Car)의 객체인지 확인한다
		//만약 obj가 Car 클래스의 객체이면 이 메소드 내부에서
		//임시로 Car c 라고 호칭할 수 있게 형변환해준다.
		//그 후에 이 메소드를 실행하는 객체의 필드와 c의 필드를 비교해서
		//차량 번호와 차종이 같으면 true를 리턴한다.
		
		//obj가 Car의 객체인지 확인할 때에는
		//instanceof 라는 키워드를 사용하면 된다.
		
		if(obj instanceof Car) {
			
			//만약 obj가 Car의 객체라면 이 조건식이 true가 나온다.
			//그렇다면 우리가 형변환을 통해 임시로 Car c라는 객체로 만들어줄 수 있다.
			
			Car c = (Car)obj;
			
			//그렇게 한 후에 c의 필드와 이 메소드를 실행하는 객체의 필드의 값을 비교하면 된다.
			
			if(number.equals(c.number) && type.equals(c.type)) {
				return true;
			}
		}
		
		return false;
	}
}