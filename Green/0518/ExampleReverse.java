import java.util.Scanner;

public class ExampleReverse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("5자리의 정수를 입력하시오: ");
		int number = input.nextInt();
		
		int number5 = number % 10;
		int number4 = ( number / 10 ) % 10;
		int number3 = ( number / 100 ) % 10;
		int number2 = ( number / 1000 ) % 10;
		int number1 = ( number / 10000 );
				
		System.out.print(number5);
		System.out.print(number4);
		System.out.print(number3);
		System.out.print(number2);
		System.out.print(number1);
	}
}