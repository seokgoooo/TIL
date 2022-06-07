import java.util.Arrays;

public class Main4 {
	static void printArray(char[] array) {			// 배열을 매개변수로 메소드화
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 'o') {
				System.out.println("찾았다: " + i);
			}
		}
	}
	
	// 배열의 모든 원소를 문자열로 표현해서 반환하는 메소드
	static String arrayToString(char[] array) {
		String str = "";				// 빈 문자열 str 변수 선언 초기화
		for (int i = 0; i < array.length; i++) {
			str += array[i];			// 합 연산으로 문자열 더해줌.
		}
		return str;
	}

	// 캐릭터 배열에서 하나의 특정 문자의 인덱스를 찾아 반환하는 메소드
	static int whereIs(char[] target, char c) {
		for (int i = 0; i < target.length; i++) {
			if (target[i] == c) {
				return i;
			}
		}
		return -1;			// 배열의 인덱스는 음수 값이 없기 때문에 못 찾았을 때는 -1을 return 해준다.
	}
	
	
	public static void main(String[] args) {
		// 선언과 동시에 값 지정
		char[] hello = {'H', 'e', 'l', 'l', 'o'};	
				
		for (int i = 0; i < hello.length; i++) {	
			System.out.print(hello[i]);
		}
		
		System.out.println();
		
		// 위의 문자 배열에 o 문자에 해당하는 인덱스를 찾아보세요.
		for (int i = 0; i < hello.length; i++) {
			if (hello[i] == 'o') {
				System.out.println("찾았다: " + i);
			}
		}
		
		// static 과 class 이름이 같기 때문에 메소드 이름만으로 호출 가능
		printArray(hello);							
		
		// 직접 메소드를 만들어서 쓰는 방법
		String result = arrayToString(hello);		
		System.out.println(result);
		
		// Arrays 클래스에 만들어진 메소드가 존재한다.
		String resultTwo = Arrays.toString(hello);	
		System.out.println(resultTwo);
		
	}
}
