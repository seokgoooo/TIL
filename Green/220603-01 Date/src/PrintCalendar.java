import java.util.Calendar;

/*
	오늘:2022-06-03 금
	일	월	화	수	목	금	토
				01	02	03	04
	달력 출력 프로그램
	
	이번달
	1일의 요일
	마지막 일(한 달에 몇 일이나 있는지)
	
*/

public class PrintCalendar {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int korDay = now.get(Calendar.DAY_OF_WEEK);

		String korDayOfWeek = "";
		switch (korDay) {
		case 1:
			korDayOfWeek = "일";
			break;
		case 2:
			korDayOfWeek = "월";
			break;
		case 3:
			korDayOfWeek = "화";
			break;
		case 4:
			korDayOfWeek = "수";
			break;
		case 5:
			korDayOfWeek = "목";
			break;
		case 6:
			korDayOfWeek = "금";
			break;
		case 7:
			korDayOfWeek = "토";
			break;
		}
		
		System.out.println("오늘 : " + year + " 년 " + month + " 월 " + day + " 일 " + korDayOfWeek + "요일");
		System.out.println("    일    월    화    수    목    금    토");

		now.set(year,month - 1,1); //월의 1일로 세팅
		int end = now.getActualMaximum(Calendar.DAY_OF_MONTH); 	//해당 월 마지막 날짜
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK); 			//해당 날짜의 요일(1:일요일 … 7:토요일)
		
		for (int i = 1; i <= end; i++) {		// 날짜만 1부터 월 마지막 날짜까지 출력
			if (i == 1) {				// 1일의 요일을 얻어서 그 요일 전까지 공백을 출력해 시작 요일을 맞춰줌
				for (int j = 1; j < dayOfWeek; j++) {
					System.out.print("    ");
				}
			}
			
			if (i < 10) { 						//한 자릿수일 경우 공백을 추가해서 줄맞추기
				System.out.print(" ");
			}
			
			System.out.print(" " + i + " ");
			
			if (dayOfWeek % 7 == 0) { 			//한줄에 7일씩 출력
				System.out.println();
			}
			dayOfWeek++;
		}
	}
}
