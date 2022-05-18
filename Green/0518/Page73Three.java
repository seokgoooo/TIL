import java.util.Scanner;

public class Page73Three {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("구의 반지름을 입력하시오: ");
		double radius = input.nextDouble();
				
		double volume = radius * radius * radius * 4 / 3;
		
		System.out.println("구의 부피: " + volume);
	}
}