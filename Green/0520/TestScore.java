// 점수 입력받아 90점 이상 A 80점 이상 B 70점 이상 C 60점 이상 D 60미만 F
import java.util.Scanner;

public class TestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
          
		String eng;
        if(score >= 90) {
            eng = "A";
        } else if(score >= 80) {
            eng = "B";
        } else if(score >= 70) {
            eng = "C";
        } else if(score >= 60) {
            eng = "D";
        } else {
            eng = "F";
        }
		System.out.println("학점은 " + eng);
    }
}