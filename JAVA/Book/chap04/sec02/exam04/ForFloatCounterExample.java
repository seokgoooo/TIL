package sec02.exam04;

public class ForFloatCounterExample {
	public static void main(String[] args) {
		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x);
//			for 문을 작성할 때는 주로 정수 변수 사용. float은 사용 하지 않는다.
		}
	}
}