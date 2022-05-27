// 2번
// 날짜 클래스
// 필드 : 연도, 월, 일
// 메소드(기능) : "2022-05-27"
//				"05/27/22"
import java.util.Scanner;
class Day {
	Scanner sc = new Scanner(System.in);
	int year;
	int month;
	int day;
	void printAll() {
		System.out.printf("2022-05-27 형식은 1을, 05/27/22 형식은 2를 입력하세요");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.printf("20%d-%02d-%d\n", year, month, day);
		} else if (choice == 2) {
			System.out.printf("%02d/%d/%d", month, day, year);
		}
	}
}
public class Question2 {
	public static void main(String[] args) {
		Day printDay = new Day();
		printDay.year = 22;
		printDay.month = 05;
		printDay.day = 27;
		printDay.printAll();
	}
}