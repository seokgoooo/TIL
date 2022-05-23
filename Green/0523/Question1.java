// 2의 제곱수를 32개 나열하고 결과값을 확인해보세요
// 2 4 8 16 32 ...
public class Question1 {
	public static void main(String[] args) {
		int x = 2;
		long result = x;
		System.out.println(x);
		for(int i = 0; i < 32; i++) {
			result *= x;
			System.out.println(result);
		}
	}
}