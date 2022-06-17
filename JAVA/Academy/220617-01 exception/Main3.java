public class Main3 {
	public static void main(String[] args) {
		try {
			System.out.println("try 블록 안");
			
			System.out.println("문장1");
			
			Object o = new Object();
			String s = (String) o;
			
			System.out.println("문장2");
			
			System.out.println("문장3");
		} catch (Exception e) {
			System.out.println("catch 블록 안");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("finally 블록 안");
		}
		
		System.out.println("정상 종료");
	}
}