package sec02.exam07;

public class FloatDoubleExample {
	public static void main(String[] args) {
		//실수값 저장
		//float var1 = 3.14; >> float 타입에 실수를 쓰려면 뒤에 f나 F를 붙여줘야 한다.
		float var2 = 3.14f;
		double var3 = 3.14;
		
		//정밀도 테스트
//		double이 float보다 2배 정도 정밀도가 높기 때문에 좀 더 정확한 데이터 저장이 가능.
//		특별한 이유가 없으면 실수 리터러을 저장할 때에는 double 타입을 사용.
		float var4 = 0.1234567890123456789f;
		double var5 = 0.1234567890123456789;
		
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
		
		//e 사용하기
		double var6 = 3e6;
		float var7 = 3e6F;
		double var8 = 2e-3;
		System.out.println("var6: " + var6);
		System.out.println("var7: " + var7);
		System.out.println("var8: " + var8);
	}
}
