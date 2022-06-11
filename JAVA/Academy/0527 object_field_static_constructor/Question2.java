// 2번
// 날짜 클래스
// 필드 : 연도, 월, 일
// 메소드(기능) : "2022-05-27"
//				"05/27/22"
import java.util.Scanner;
class Date {
	Scanner sc = new Scanner(System.in);
	int year;
	int month;
	int day;
	void printYMD() {
		System.out.printf("2022-05-27 형식은 1을, 05/27/22 형식은 2를 입력하세요");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.printf("%d-%02d-%02d\n", year, month, day);
		} else if (choice == 2) {
			System.out.printf("%02d/%02d/%s\n", month, day, getYearTwoDigit());
		}
	}
	
	String getYearTwoDigit() {
		return String.format("%02d", year % 100);
	}
}
public class Question2 {
	public static void main(String[] args) {
		Date d = new Date();
		d.year = 2022;
		d.month = 05;
		d.day = 27;
		d.printYMD();
		// String year = d.getYearTwoDigit();
		// System.out.println(year);
	}
}