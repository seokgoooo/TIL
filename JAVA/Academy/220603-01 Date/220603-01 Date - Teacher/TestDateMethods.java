import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDateMethods {
	public static void main(String[] args) {
//		Calendar now = Calendar.getInstance();
//		now.set(Calendar.YEAR, 2000);
//		now.set(2022, Calendar.JUNE, 4);
//		now.add(Calendar.DAY_OF_MONTH, 1);
		
//		Date date = now.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String result = dateFormat.format(date);
//		System.out.println(result);
		
		LocalDate now = LocalDate.now();
//		LocalDate someDay = LocalDate.of(2022, 6, 4);
//		System.out.println(tomorrow.equals(nowPlusOne));
		
		// 내일의 날짜 객체
		LocalDate nowPlusOne = now.plusDays(1);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String result = dateFormat.format(nowPlusOne);
		System.out.println(result);
	}
}