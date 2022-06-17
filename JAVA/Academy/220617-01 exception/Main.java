import java.util.InputMismatchException;
import java.util.Scanner;
// try - catch
// java.util.InputMismatchException 이렇게 뜨는 에러는
// java.util 패키지에 있는 InputMismatchException 클래스의 인스턴스가 에러가 생겼을 때 메시지를 준다. 는 뜻
// 정수 2개 입력받아서 나누기한 몫을 출력하는 프로그램
public class Main {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Scanner scan = new Scanner(System.in);

//		if (right != 0) {
//			System.out.println("나눈 몫: " + (left / right));
//		} else {
//			System.out.println("분모에 0 입력 멈춰");
//		}

		try {
			// 프로그램 흐름 문장
			System.out.println("왼쪽 수 입력?");
			int left = scan.nextInt();
			System.out.println("오른쪽 수 입력?");
			int right = scan.nextInt();
			System.out.println("나눈 몫: " + (left / right));
			scan.close();
		} catch (ArithmeticException e) {
			// 예외 처리하는 문장
			System.out.println("분모에 0 입력 멈춰");
			
		} catch (InputMismatchException e) {
			
			System.out.println("다른타입 입력 멈춰");
//			System.out.println(e.getMessage()); ---> message가 없어서 null 출력
			e.printStackTrace();	// 예외가 발생되었던 경로를 출력
			// 에러 뜨면 나오는 빨간줄은 StackTrace라고 부른다.
			// 제일 아래줄에 있는 문장일수록 가장 오래된 문장
			
		} finally {
			// 예외 발생 여부에 상관없이 무조건 실행
		}

		System.out.println("프로그램 정상 종료");

	}
}
