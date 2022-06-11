import java.time.LocalDate;
import java.util.Calendar;

public class TestDateMethods {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
//		내일의 날짜 객체
		now.plusDays(1);
		System.out.println(now.plusDays(1));
		LocalDate nowPlusOne = now.plusDays(1);
		
		LocalDate tomorrow = LocalDate.of(2022, 6, 4);
		System.out.println(tomorrow.equals(nowPlusOne));
		
		Calendar nownow = Calendar.getInstance();
		nownow.set(2022, Calendar.JUNE, 4);
		nownow.add(Calendar.DAY_OF_MONTH, 1);
	}
}