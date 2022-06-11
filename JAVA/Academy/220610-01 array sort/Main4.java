import java.math.BigDecimal;
import java.math.BigInteger;

public class Main4 {
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		
		BigInteger value1 = BigInteger.valueOf(Long.MAX_VALUE + Long.MAX_VALUE);
		// long 보다 더 큰 수를 담기 위한 클래스
		
		BigInteger value2 = new BigInteger("9223372036854775808");
		// 얘는 산술 연산자가 안되고 메소드로 해줘야 한다. 당연함 참조형 객체라서
		System.out.println(value2);
		System.out.println(value2.add(new BigInteger("10")));
		// 이걸 한다고해도 value2 가 바뀌진 않는다~
		System.out.println(value2);
		
		BigDecimal dec = new BigDecimal("0.1234567879");
		System.out.println(dec);
		
		BigDecimal d = new BigDecimal(0.1);
		// double 그대로 집어 넣으면 부정확한 값이라 0.1 그대로 안나오고 근사값으로 나옴
		System.out.println(d);
	}
}