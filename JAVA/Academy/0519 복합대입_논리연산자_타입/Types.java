public class Types {
	public static void main(String[] args) {
		byte b = 100;
		short s = 30000;
		int i = 10_000_000;
		long l = 123456789L;
		long sum = 100 + 100L;
		System.out.println(sum);

		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		boolean t = true;
		boolean f = false;

		char a = 'a';
		char ga = '가';
		char num1 = '1';
		char what = 65;
		
		float floatEx = 123.456F;
		double doubleEx = 7777.88888;
		float one = 0.1F;
		System.out.printf("%.15f", one * 22);
		System.out.printf("%010d", 10);
	}
}
