// 컵 사이즈 알려주기 입력받아서 200이상이면 라지 100-200이면 미디움 100미만이면 small
import java.util.Scanner;

public class TestElseIf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cup = sc.nextInt();
		
		String size;
		if (cup >= 200) {
			size = "large";
		} else if (cup >= 100) {
			size = "medium";
		} else {
			size = "small";
		}
		
		System.out.println("컵사이즈는 " + size);
	}
}