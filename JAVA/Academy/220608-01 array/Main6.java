public class Main6 {
	// 정수 2개를 전달받아 합을 구해서 반환하는 메소드
	public static int sum(int... numbers) {
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			return sum;
		}		
	
	public static void someMethod(int... arr) {
		// 향상된 for문 (for-each)
		// 값을 순서대로 읽기 위해 사용 (확인 용도, 값 수정은 X)
		// ( 담고 싶은 변수 : 여러개를 담고 있는 객체( 배열, 등등등 ) )
		// 반복될 때 마다 arr 에서 number로 1개씩 꺼내옴
		// 인스턴스에 접근해서 값을 바꾼다.
		// 방향은 왼쪽에서 오른쪽 ( index 0 ---> ) 고정 되어있음.
		// index에 조건 걸어줄 수 없음. 무조건 처음부터 끝까지 스캔
		for (int number : arr) {
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		int result = sum(10, 20, 30, 40, 50, 60, 70, 80);
		System.out.println(result);
		
		int[] arr = { 10, 20, 30, 40, 50 };
		
		//	someMethod(arr);
		someMethod(new int[] { 20, 30, 40, 50, 60 });
		System.out.println("---");
		someMethod(new int[] { 4, 5, 6 });
		System.out.println("종료");
		
		// 매개변수에 ...(가변길이 parameter) 은 int[] 이런식으로 배열이라고 지정을 안해주고
		//	40, 50, 60 이렇게 써줘도 배열을 알아서 만듬
		//	매개변수가 여러가지 있을 때는 맨 마지막 type 에 위치해야 함.
		someMethod(40, 50, 60, 70, 80);
	}
}