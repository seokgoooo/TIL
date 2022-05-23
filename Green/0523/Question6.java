// 입력 : 영단어(latin 문자열)에서 / 출력 : 모음(a e i o u)이 몇 개인지
import java.util.Scanner;
public class Question6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		System.out.print("영어 입력: ");
		String latin = sc.nextLine();			
		
		for (int i = 0; i < latin.length(); i++) {
			if (latin.charAt(i) == 'a' || latin.charAt(i) == 'e' || latin.charAt(i) == 'i' || latin.charAt(i) == 'o' || latin.charAt(i) == 'u') {
				result++;
			}
		}
		System.out.println("모음의 수: " + result);
	}
}