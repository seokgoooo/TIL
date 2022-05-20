public class StringMethods {
	public static void main(String[] args) {
		String hello = "hello";
		
		int index = hello.indexOf('l');
		System.out.println(index);
		
		int index2 = hello.lastIndexOf('l');
		System.out.println(index2);
		
		int index3 = hello.lastIndexOf('l', 3);
		System.out.println(index3);
		
		int notFound = hello.indexOf('a');
		System.out.println(notFound);
	}
}