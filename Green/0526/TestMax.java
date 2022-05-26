public class TestMax {
	public static int max(int left, int right) {
		return left > right ? left : right;
	}
	
	public static void main(String[] args) {
		int x = 100;
		int y = 50;
		int z = 75;
		
		int result1 = max(x, y);
		int finalResult = max(result1, z);
		
		System.out.println(finalResult);
		
		int m = max(3, max(7, max(5, 1)));
	}
}