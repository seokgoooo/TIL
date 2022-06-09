import java.util.Arrays;

public class Main5 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30};
		int[] copy = Arrays.copyOf(arr, arr.length);	// 배열 복사 메소드 : copyOf(배열, 배열길이)
		
		System.out.println(Arrays.toString(copy));		// 배열 출력 [ , , ]
		System.out.println(Arrays.equals(arr, copy));	// 배열 비교 : 길이, 원소값 둘 다 같으면 true, 아니면 false
		
		Arrays.fill(arr, 100);
		System.out.println(Arrays.toString(arr));
		
		int[] temp = { 40, 50, 60 };
		
		int[] another = Arrays.copyOfRange(temp, 2, temp.length);
		System.out.println(Arrays.toString(another));		
	}
}