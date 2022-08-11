package hello;

public class TestValidator {
	public static void main(String[] args) {
		PersonsValidator v = new PersonsValidator();
		v.isValidName("테스트");
		v.isValidName("테스트1숫자");
		v.isValidName("특수문자!@#$");
		v.isValidName(" ");
		v.isValidName(null);
		v.isValidName("asdfjasnvoiawnegjawepirgfjawopiefjawiorfe");
	}
}
