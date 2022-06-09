public class Main2 {
	public static void main(String[] args) {
		// 길이가 5인 정수(int)형 배열을 선언 초기화 하고 모든 원소(element)의 값을 100으로 설정해보세요.
		int[] element = new int[5];
		
		for (int i = 0; i < element.length; i++) {
			element[i] = 100;
			System.out.println(i + "번째 index의 원소값: " + element[i]);
		}
		
//		element[5] = 100;
//		배열은 0부터 시작한다. 는 것을 항상 주의하자
	}
}