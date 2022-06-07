public class Main {
	public static void main(String[] args) {
		int[] aBox;				// 정수형 배열 변수 선언.
		aBox = new int[4];		// 길이가 4인 배열 초기화
		
		System.out.println("배열의 길이값: " + aBox.length);
//		aBox.length = 10;	초기화할 때 정해준 길이의 값은 변경 불가능
		
		aBox[0] = 56;
		aBox[1] = 57;
		aBox[2] = 58;
		aBox[3] = 59;
		
		System.out.println(aBox[0]);
		System.out.println(aBox[1]);
		System.out.println(aBox[2]);
		System.out.println(aBox[3]);
	}
}
