package sec03.exam02;

public class KoreanExample {

	public static void main(String[] args) {
		Korean k1 = new Korean("���ڹ�", "011225-1234567");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);

		System.out.println("------------------------");
		
		Korean k2 = new Korean("���ڹ�", "930525-0654321");
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}