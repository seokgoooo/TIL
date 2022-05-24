public class Question3 {
	public static void main(String[] args) {
		int a1 = 1;
		int a2 = 1;
		int a3;
		
		System.out.print(a1 + " ");
		System.out.print(a2 + " ");
		for (int i = 1; i < 10; i++) {
			a3 = a1 + a2;
			System.out.print(a3 + " ");
			a1 = a2;
			a2 = a3;
		}
	}
}
