package sec02.exam08;

public class BooleanExample {
	public static void main(String[] args) {
//		boolean 타입 변수는 주로 두 가지 상태값에 따라 조건문과 제어문의 실행 흐름을 변경하는 데 사용.
		boolean stop = true;
		if(stop) {
			System.out.println("중지합니다.");
		} else {
			System.out.println("시작합니다.");
		}
	}
}
