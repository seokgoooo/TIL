import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
	오늘:2022-06-03 금
	일  월   화   수   목   금   토
	         01 02 03 04 
	05 06 07 08 09 10 11 
	12 13 14 15 16 17 18 
	19 20 21 22 23 24 25 
	26 27 28 29 30
 */

// 이번 달
// 1일의 요일
// 마지막 일(한달에 몇 일이나 있는지)
public class PrintCalendar {
	public static void main(String[] args) {
		LocalDate now = LocalDate.of(2022, 8, 7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd eee");
		String result = formatter.format(now);
		LocalDate firstDay = LocalDate.of(now.getYear(), now.getMonthValue(), 1);
		int dayOfWeek = firstDay.getDayOfWeek().getValue();
		int length = now.lengthOfMonth();
		
		System.out.println("오늘:" + result);
		System.out.println("일  월   화   수   목   금   토");
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= length; i++) {
			System.out.printf("%02d ", i);
			dayOfWeek++;
			if (dayOfWeek % 7 == 0) {
				System.out.println();
			}
		}
	}
}
