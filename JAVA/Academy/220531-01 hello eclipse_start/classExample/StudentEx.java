package classExample;
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
import java.util.ArrayList;
import java.util.Scanner;

//Student의 필드 : 이름, 국어, 영어, 수학
//Student의 메소드 : 총점, 평균, getter/setter, toString()

class Student {
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
		return "'name': \"" + name + "\", 'korean': " + kor + ", 'english': " + eng + ", 'math': " + math + "]";
	}
}

public class StudentEx {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
//		System.out.println("list 크기 : " + stlist.size());
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("감자고 성적 관리 프로그램");
			System.out.println("1.입력  2.출력  3.종료");
			System.out.print(">   ");
			int choice = scan.nextInt();

			if (choice == 1) {
				// 정보를 담을 Student 객체 생성
				Student student = new Student();

				// setter를 통안 데이터 입력.
				System.out.print("학생이름 : ");
				scan.nextLine();
				student.setName(scan.nextLine());
				System.out.print("국어 : ");
				student.setKor(scan.nextInt());
				System.out.print("영어 : ");
				student.setEng(scan.nextInt());
				System.out.print("수학 : ");
				student.setMath(scan.nextInt());

				// 이렇게 데이터가 담긴 객체를 list에 추가해주면 된다.
				list.add(student);

			} else if (choice == 2) {
				// 만약 리스트가 비어있으면 아무것도 출력 안하고
				// 뭔가 있으면 전체를 출력한다.
				if (list.size() == 0) {
					System.out.println("출력할 내용이 없습니다.");
				} else {
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}
				}

			} else if (choice == 3) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
		}
		scan.close();
	}
}