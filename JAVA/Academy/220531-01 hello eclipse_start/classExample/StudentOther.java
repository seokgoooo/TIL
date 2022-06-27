package classExample;
//학생 관리 프로그램
//콘솔 입출력
//반에 학생을 등록. 3명
//이름 목록을 볼 수 있어야 하고
//평균을 볼 수 있고
//1등 학생의 정보도 볼 수 있는 프로그램.
//자유롭게

//기존에 만들었던 클래스 << 수정. 수정을 해야하는 이유와 전 후가 어떻게 바뀌었는지 '다 기록'

//학급(반)
//학생1
//학생2
//학생3

//1. 3명의 학생의 이름을 콘솔에 출력할 수 있음.
//2. 학생 3명의 총 평균을 알려줄 수 있음.
//3. 평균점수가 가장 높은 학생(참조)을 알려줄 수 있음. => 동일 점수일 경우 1, 2, 3 순
import java.util.Scanner;

class Score {
	Scanner scan = new Scanner(System.in);
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

	public int getClassnum() {
		return classNum;
	}

	public void setClassnum(int c) {
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

class Student {
	Scanner scan = new Scanner(System.in);
	private Score stu1;
	private Score stu2;
	private Score stu3;

	public Student(Score stu1, Score stu2, Score stu3, Score stu4) {
		this.stu1 = stu1;
		this.stu2 = stu2;
		this.stu3 = stu3;
	}

	public Student() {

	}

	public Score setScore(Score stu) {
		System.out.print("반:  ");
		stu.setClassnum(scan.nextInt());
		System.out.println();

		System.out.print("학생 이름:  ");
		scan.nextLine();
		stu.setName(scan.nextLine());
		System.out.println();

		System.out.print("국어:  ");
		stu.setKor(scan.nextInt());
		System.out.println();

		System.out.print("영어:  ");
		stu.setEng(scan.nextInt());
		System.out.println();

		System.out.print("수학:  ");
		stu.setMath(scan.nextInt());
		System.out.println();

		return stu;
	}

	public void mainLogic() {

		Score stu1 = new Score();
		Score stu2 = new Score();
		Score stu3 = new Score();

		while (true) {

			System.out.println("학생 관리 프로그램");
			System.out.println("*** 1. 등록 *** 2. 이름 목록 *** 3. 평균 *** 4. 1등 학생? *** 5. 종료");
			System.out.print(">>>     ");
			int choice = scan.nextInt();

			if (choice == 1) {
				this.stu1 = setScore(stu1);
				this.stu2 = setScore(stu2);
				this.stu3 = setScore(stu3);
			}

			if (choice == 2) {
				System.out.println(stu1.getName());
				System.out.println(stu2.getName());
				System.out.println(stu3.getName());
			}

			if (choice == 3) {
				stu1.getAveragePrint();
				stu2.getAveragePrint();
				stu3.getAveragePrint();
			}

			if (choice == 4) {
				if (stu1.getAverage() >= stu2.getAverage() && stu1.getAverage() >= stu3.getAverage()) {
					System.out.println(stu1.getName());
				} else if (stu2.getAverage() >= stu3.getAverage() && stu2.getAverage() >= stu1.getAverage()) {
					System.out.println(stu2.getName());
				} else {
					System.out.println(stu3.getName());
				}
			}

			if (choice == 5) {
				break;
			}

			else {
				System.out.print("다시 입력 >>>     ");
			}
		}
	}
}

public class StudentOther {
	public static void main(String[] args) {
		Student a = new Student();
		a.mainLogic();
	}
}