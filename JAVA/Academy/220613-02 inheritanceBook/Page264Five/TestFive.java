package Page264Five;

/*
 * 5. 일반적인 음식을 나타내는 Food 클래스를 상속받아서
 * 	멜론을 나타내는 Melon 클래스를 작성하여 보자.
 * Food 클래스는 칼로리, 가격, 중량 등의 정보를 가진다.
 * Melon 클래스는 추가로 경작 농원 정보를 가진다.
 * 생성자, 접근자, 설정자를 포함하여서 각각의 클래스를 작성한다.
 * 이들 클래스들의 객체를 만들고
 * 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라
 */

public class TestFive {
	public static void main(String[] args) {
		Food one = new Food(848, 6000, 815.58);
		System.out.println(one.toString());
		
		Melon two = new Melon(51874, 818789, 718.54847,"farm");
		System.out.println(two.toString());
	}
}