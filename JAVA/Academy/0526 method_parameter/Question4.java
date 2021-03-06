// 4. 키(실수, 미터단위)와 몸무게(실수, kg단위)를 전달받아
// 한국기준 BMI 지수(실수) 구해 반환하는 메소드
// BMI = (몸무게) / (키)^2
import java.util.Scanner;
public class Question4 {
	public static double bmi(double meter, double kg) {
		Scanner sc = new Scanner(System.in);
		System.out.print("키 입력 (단위 m): ");
		meter = sc.nextDouble();
		System.out.print("몸무게 입력 (단위 kg): ");
		kg = sc.nextDouble();
		return kg / (meter * meter);
	}
	
	public static void main(String[] args) {
		double a = 0;
		double b = 0;		
		System.out.println("BMI : " + bmi(a, b));
	}
}