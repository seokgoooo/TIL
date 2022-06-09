import java.time.LocalDate;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
//		java.util.Calendar
		Calendar now = Calendar.getInstance();
		
		System.out.println(now.get(1));	
		System.out.println(now.get(2) + 1);	
		System.out.println(now.get(5));
		
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH) + 1);
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
					
//		1.8 ~~~ java.time.LocalDate
		LocalDate nownow = LocalDate.now();
		System.out.println(nownow.getYear());
		
		System.out.println(nownow.getMonth());
		System.out.println(nownow.getMonthValue());
		
		System.out.println(nownow.getDayOfMonth());
		
		System.out.println(nownow.getDayOfWeek());
		System.out.println(nownow.getDayOfWeek().getValue());
	}
}