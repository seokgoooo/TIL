public class IntegerToString {
	public static void main(String[] args) {
		String strNum = String.valueOf(12345);
		System.out.println(strNum);
		
		int i = 1557;
		String strNum1 = "" + i;
		System.out.println(strNum1);
		System.out.println(strNum1.charAt(0));
	}
}