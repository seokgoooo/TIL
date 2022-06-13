package Page264Six;

/*
 * 6. 일반적인 휴대폰을 나타내는 Phone 클래스를 작성한다.
 * Phone 에는 제조사, 가격, 통신타입 (2g 또는 3g) 둥의 정보가 저장되어 있다.
 * Phone 에서 상속받아서 SmartPhone 클래스를 작성하여 보자.
 * SmartPhone 클래스에는 운영체제 타입, 운영체제 버전, 내부 메모리 크기, 카메라 장착 여부, 블루투스 지원 여부 등의 필드가 추가된다.
 * 생성자, 접근자, 설정지를 포함하여서 각각의 클래스를 작성한다.
 * 이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라 
 */

public class TestSix {
	public static void main(String[] args) {
		Phone one = new Phone("maker", 5841848, "3G");
		System.out.println(one.toString());
		
		SmartPhone two = new SmartPhone("maker", 5818181, "3G", "osType", 1.5, 80.5, true, true);
		System.out.println(two.toString());
	}
}