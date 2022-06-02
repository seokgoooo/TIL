// 학생 관리 프로그램
// 콘솔 입출력
// 반에 학생을 등록. 3명
// 이름 목록을 볼 수 있어야 하고
// 평균을 볼 수 있고
// 1등 학생의 정보도 볼 수 있는 프로그램.
// 자유롭게

// 기존에 만들었던 클래스 << 수정. 수정을 해야하는 이유와 전 후가 어떻게 바뀌었는지 '다 기록'

// 학급(반)
// 학생1
// 학생2
// 학생3

// 1. 3명의 학생의 이름을 콘솔에 출력할 수 있음.
// 2. 학생 3명의 총 평균을 알려줄 수 있음.
// 3. 평균점수가 가장 높은 학생(참조)을 알려줄 수 있음. => 동일 점수일 경우 1, 2, 3 순
import java.util.Scanner;

class Score {
	Scanner sc = new Scanner(System.in);
	private int classNum;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score() {

	}

	public Score(int c, String n, int k, int e, int m) {
		classNum = c;
		name = n;
		kor = k;
		eng = e;
		math = m;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int c) {
		classNum = c;
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

	public void getList() {
		System.out.println(name);
	}

	public int getSum() {
		return kor + eng + math;
	}

	public double getAverage() {
		return (double) getSum() / 3;
	}

	public void getAveragePrint() {
		System.out.println((double) getSum() / 3);
	}
}