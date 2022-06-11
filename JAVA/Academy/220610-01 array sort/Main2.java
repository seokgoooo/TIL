public class Main2 {
	public static void main(String[] args) {
		int number = 22;
		// Wrapper class	기초형 타입을 참조형 타입으로 바꿔보자!
		//		Byte		바꿔주는 과정을 boxing이라고 한다.
		//		Short
		//		Integer
		//		Long
		//		Float
		//		Double
		//		Character
		//		Boolean
		Integer i = new Integer(10); // deprecated	얘는 없어질 아이라 다른것으로 대체하라고 알려준다.
		Integer i2 = Integer.valueOf(500); // boxing
		int primitiveInt = i2.intValue();	// un-boxing
		
		// System.out.println(primitiveInt);
		Integer auto = 100; // auto-boxing		// 개발자의 편의를 위해 따로 메소드 사용하지 않고 하게 해줌.
		int un = auto;
		
		Integer value = Integer.valueOf("5959");
		int result = Integer.valueOf("1234");
	}
}
