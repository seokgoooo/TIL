// 정수 2개의 연산자(문자열 + - * /) 등을 입력받아 사칙연산을 수행하는 계산기 프로그램
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.print("+ - * / 중 에 하나 입력하시오: ");
		String cal = sc.nextLine();
		
		System.out.print("정수 입력 하시오: ");
        int a = sc.nextInt();
		System.out.print("정수 입력 하시오: ");
		int b = sc.nextInt();
        
		if(cal.equals("+")) {
            System.out.println("답은: " + (a + b));
        } else if(cal.equals("-")) {
            System.out.println("답은: " + (a - b));
        } else if(cal.equals("*")) {
            System.out.println("답은: " + (a * b));
        } else {
            System.out.println("답은: " + (a / b));
        }		
    }
}