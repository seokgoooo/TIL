// 초단위의 시간을 입력받아
// 시간 분 초로 변환을 하는 프로그램


import java.util.Scanner;

public class Time {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("초를 입력: ");
		int sec = input.nextInt();
		
		int hour = (sec / 3600);
		int min = (sec % 3600 / 60);
		int seccal = (sec % 60);
		System.out.print(hour + " 시간 " + min + " 분 " + seccal + " 초");
	}
}