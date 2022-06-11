public class CarEx01 {
	public static void main(String[] args) {
		//객체를 만들어봅시다
		//객체는
		//클래스이름 객체이름 = 뉴 클래스이름();
		//로 만들어줄 수 있다.
		Car c = new Car();
		
		//객체의 필드나 메소드를 접근할 때에는
		//객체이름.필드 혹은 객체이름.메소드로 접근 가능하다.
		//객체이름.필드 는 하나의 변수처럼 우리가 쓸 수 있다.
//		c.number = "00가 0000";
//		c.year = 2020;
//		c.type = "페라리";
//		c.color = "빨간색";
//		c.price = 10000;
		
		//캡슐화 된 필드에 값을 넣어줄때에는
		//객체의 셋터 메소드를 호출해 주면 된다.
		c.setNumber("00가 0000");
		c.setYear(2020);
		c.setType("페라리");
		c.setColor("빨간색");
		c.setPrice(10000);
		
		//System.out.println("이차의 가격: "+c.price+" 만원");
		
		//캡슐화된 필드의 값을 호출할 때에는
		//객체의 겟터 메소드를 호출해주면 된다.
		System.out.println("이차의 가격: "+c.getPrice()+" 만원");
		
		c.turnOn();
		c.print();
		
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
		
		c.comparePrice(c2);
		c2.comparePrice(c);
		
		Car c3 = new Car();
		c3.print();
		
		c3.setNumber("99하 9999");
		c3.setYear(2020);
		c3.setType("K5");
		c3.setColor("흰색");
		c3.setPrice(3000);
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
		//System.out.println() 에
		//객체를 파라미터로 넘기면
		//해당 객체의 toString() 메소드의 string 결과값을
		//화면에 출력한다.
		
		//c2 객체와 c3객체를 비교해보자
		System.out.println("c2.equals(c3): "+c2.equals(c3));
		
		//java.lang.Object의 equals() 메소드는 다음과 같이
		//구현되어있다.
		// public boolean equals(Object obj){
		//    return this == obj;
		// }
		
		// 위 코드에서는 우리가 생각한 값 비교 대신 주소값 비교를 하기 때문에
		// 우리가 equals()메소드를 오버라이드 하지 않고 사용하면
		// 정확한 값을 얻을 수 없다!
		
	}
}