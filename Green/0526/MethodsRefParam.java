public class MethodsRefParam {
	public static String concat(String left, String right) {
		return left + right;
	}
	
	public static void main(String[] args) {
		String h = "Hello";
		String w = "World";
		String result = concat(h, w);
		
		System.out.println(result);
	}
}