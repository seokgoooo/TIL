public class OneLineIf {
	public static void main(String[] args) {
		boolean con = true;
		
		// 한 문장일 경우 {}가 없어도 된다.
		// if(con)
			// System.out.println("참일 경우 실행할 문장");
		// else
			// System.out.println("거짓일 경우 실행할 문장");
		
		// ? 삼항연산자
		String result = (con) ? "참" : "거짓";
		
		System.out.println(result);
		
		System.out.println("프로그램 종료");
	}
	
	
}