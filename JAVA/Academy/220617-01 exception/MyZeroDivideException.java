import java.time.LocalTime;

// 전세계에서 공통으로 쓰는 자바가 만들어놓은 예외 클래스들을 최대한 활용하고 도저히 안되면
// 내가 필요한 맞춤 예외를 Exception 상속을 통해 구현할 수 있다
public class MyZeroDivideException extends RuntimeException {
	public MyZeroDivideException(String message) {
		super(message + ", " + LocalTime.now() + "에 발생");
	}
}