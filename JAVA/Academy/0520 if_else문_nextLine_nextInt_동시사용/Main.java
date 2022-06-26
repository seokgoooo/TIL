import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// inputString
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println("한줄을 입력하세요.");
		scan.nextLine();
		String line = scan.nextLine();
		System.out.println(line);

		// Integer To String
		String strNum = String.valueOf(12345);
		System.out.println(strNum);

		int intNum = 1557;
		String strNum1 = "" + intNum;
		System.out.println(strNum1);
		System.out.println(strNum1.charAt(0));

		String str = "Hello World";
		System.out.println(str);
		String s2 = "다음 문자열";
		System.out.println(s2);
		String concat = str + 1 + "\n" + true + s2 + 3.0;
		System.out.println(concat);

		String hello = "Hello";
		char h = hello.charAt(0);
		System.out.println(h);
		// System.out.println(hello.charAt(-1));
		System.out.println(hello.charAt(1));
		System.out.println(hello.charAt(2));
		System.out.println(hello.charAt(3));
		System.out.println(hello.charAt(4));

		int length = hello.length();
		System.out.println(length);

		double d = 123.456;
		int i = d;
		System.out.println(i);

		// TypeConversion
		int intEx;
		double test;

		test = 5 / 4;
		System.out.println(test);
		test = (double) 5 / 4;
		System.out.println(test);
		test = 5 / (double) 4;
		System.out.println(test);
		test = (double) 5 / (double) 4;
		System.out.println(test);
		intEx = (int) 1.3 + (int) 1.8;
		System.out.println(intEx);

		// String method
		String helloTest = "hello";
		int index = helloTest.indexOf('l');
		System.out.println(index);
		int index2 = helloTest.lastIndexOf('l');
		System.out.println(index2);
		int index3 = helloTest.lastIndexOf('l', 3);
		System.out.println(index3);
		int notFound = helloTest.indexOf('a');
		System.out.println(notFound);

		String helloA = "Hello";
		String helloB = "Hello";
		String lloStr = "llo";
		System.out.println(helloA == helloB);
		System.out.println(helloA == ("He" + lloStr));
		System.out.println("-----문자열 값 동등 확인-----");
		System.out.println(helloA.equals("He" + lloStr));

		// TestIf
		boolean condition = true;
		if (condition) {
			System.out.println("조건문 블록 안입니다.");
		}
		System.out.println("프로그램 종료");

		int b = 2;
		if (b >= 2) {
			System.out.println("조건문 블록 안입니다.");
		}
		System.out.println("프로그램 종료");

		// BlockScope
		int blockA = 10;
		{
			int blockB = 20;

			// int blockA = 59;
			System.out.println("가능한가?");
			System.out.println(blockA);
			System.out.println(blockB);
		}
		// System.out.println(blockB);

		boolean notOperator = true;
		notOperator = !notOperator;
		System.out.println(notOperator);
//				!((10 > 3) && (3 == 3)); // false
//				!(!(10 > 3) || (3 == 3)); // false
	}
}