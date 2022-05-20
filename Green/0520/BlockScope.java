public class BlockScope {
	public static void main(String[] args) {
		int a = 10;
		{
			int b = 20;
			
			// int a = 59;
			System.out.println("가능한가?");
			System.out.println(a);
			System.out.println(b);
		}
		// System.out.println(b);
	}
}
