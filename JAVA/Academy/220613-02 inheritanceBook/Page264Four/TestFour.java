/*
 * 4. 일반적인 책을 나타내는 Book 클래스를 상속받아서 잡지를 나타내는 Magazine 클래스를 작성하여 보자.
 * Book 클래스는 제목, 페이지수, 저자 등의 정보를 가진다.
 * Magazine 클래스는 추가로 발매일 정보를 가진다.
 * 생성자, 접근자, 설정자를 포함하여서 각각의 클래스를 작성한다.
 * 이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라
 */

package Page264Four;

public class TestFour {
	public static void main(String[] args) {
		Book one = new Book("title", 300, "author");
		System.out.println(one.toString());
		
		Magazine two = new Magazine("title", 800, "author", 81);
		System.out.println(two.toString());
	}
}