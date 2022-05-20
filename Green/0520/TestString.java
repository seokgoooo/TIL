public class TestString {
	public static void main(String[] args) {
		String str;
		str = "Hello World";
		
		System.out.println(str);
		
		String s2 = "다음 문자열";
		System.out.println(s2);
		
		String concat = str + 1 + "\n" + true + s2 + 3.0;
		System.out.println(concat);
	}
}