// // 학생

// 이름
// 국어 점수
// 영어 점수
// 수학 점수

// 생성자
// getter/setter

// 자기 평균 점수를 알려줄 수 있음

class Info {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Info(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int k) {
		kor = k;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int e) {
		eng = e;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int m) {
		math = m;
	}
	
	public void getAverage() {
		System.out.println(name);
		System.out.println((kor + eng + math) / 3);
	}
}

public class Student {
	public static void main(String[] args) {
		Info a = new Info("이름", 90, 50, 80);
		a.getAverage();
	}
}