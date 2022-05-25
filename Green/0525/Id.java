// 주민번호를 입력하면 성별을 출력하는 프로그램
// ex) xxxxxx-2xxxxxx
import java.util.Scanner;

public class Id {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String MF = " ";
		
		System.out.print("주민번호를 입력하시오:");
		String id = sc.nextLine();
       	
		if (id.length() == 14) {
			char result = id.charAt(7);
			switch (result) {
				case '1':	case '3':
				MF = "남성";
				break;
				case '2':	case '4':
				MF = "여성";
				break;
				default:
				System.out.println("잘못 입력되었습니다.");
				break;
			}
			System.out.println("성별은 " + MF);
		} else {
			System.out.println("잘못 입력되었습니다.");
		}
		
	}
}