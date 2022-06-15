package equals;

public class Main {
	public static void main(String[] args) {
		String a = new String("a");
		String b = "a";
		
		System.out.println(a == b);
		System.out.println(a.equals(b));
	}
}