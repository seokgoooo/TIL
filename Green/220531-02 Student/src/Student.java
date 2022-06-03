// Student의 필드 : 이름, 국어, 영어, 수학
// Student의 메소드 : 총점, 평균, getter/setter, toString()

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 총점
	public int sum() {

		return kor + eng + math;
	}

	// 평균
	public double avg() {

		return sum() / (double) 3;
	}

	// toString() 오버라이드
	public String toString() {

		String returnValue = new String();
		returnValue += "이름: " + name;
		returnValue += ", 국어: " + kor;
		returnValue += ", 영어: " + eng;
		returnValue += ", 수학: " + math;

		return "'name': \"" + name + "\", 'korean': " + kor + ", 'english': " + eng + ", 'math': "
				+ math + "]";

	}
}