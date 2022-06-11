public class Main3 {
	public static void main(String[] args) {
		int number1 = 10;
		
		Integer refNumber = Integer.valueOf(10);
		refNumber.compareTo(20);
		
//		boxing을 하는 이유는 List 에는 기초형이 못 담긴다.
//		참조형으로 만들어줘서 List에 담아보자~
		
		System.out.println(Integer.max(100, 500));
	}
}