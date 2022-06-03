import java.util.Scanner;

public class StudentLogic {
	Scanner sc = new Scanner(System.in);
	/* 클래스이름 : Scanner 객체이름 : sc = new 클래스이름 : Scanner();
	 * sc라는 객체 생성
	 * 
	 * 
	 * 
	 */
	private StudentData studentA;
	private StudentData studentB;
	private StudentData studentC;

	public StudentLogic(StudentData studentA, StudentData studentB, StudentData studentC) {
		this.studentA = studentA;
		this.studentB = studentB;
		this.studentC = studentC;

		/*
		 * 1. 파라미터가 있는 생성자
		 * 파라미터로 넘어온 studentA를 우리의 필드 studentA에 넣어보자!
		 * 만약 필드와 파라미터의 이름이 같다면 필드에 앞에
		 * this. 를 붙여서 이 메소드를 호출하는 객체의 필드라는 것을 입력하면 된다.
		 * 
		 * 매개변수(parameter)와 인수(arguments)
		 * 매개변수 : 메소드에 입력으로 전달된 값을 받는 변수
		 * 인수 : 메소드를 호출할 때 전달하는 입력값
		 * 
		 */

	}

	public StudentLogic() {
		/*
		 * 생성자(Constructor) : 메소드명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메소드
		 * 생성자의 규칙
		 * 1. 클래스명과 메소드명이 동일하다.
		 * 2. 리턴타입을 정의하지 않는다. (void도 사용하지 않는다)
		 * 
		 * 생성자는 객체가 생성될 때 호출된다. 즉, new 키워드가 사용될 때 호출된다.
		 * 생성자를 사용하면 필수적인 행동을 객체 생성시에 제어할 수 있다.
		 * 
		 * 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 디폴트 생성자를 추가한다.
		 * 하지만 사용자가 작성한 생성자가 하나라도 구현되어 있다면
		 * 컴파일러는 디폴트 생성자를 추가하지 않는다.
		 * 
		 * 파라미터가 없는 생성자의 경우 우리가 임의 값을 호출해주는 대신
		 * 참조형 데이터타입의 필드에 대한 생성자를 호출해 주는 것이 가장 좋은 방법이다!
		 */
	}

	public StudentData setScore(StudentData student) {
		System.out.print("반:  ");
		student.setClassNum(sc.nextInt());

		System.out.print("학생 이름:  ");
		sc.nextLine();
		student.setName(sc.nextLine());

		System.out.print("국어:  ");
		student.setKor(sc.nextInt());

		System.out.print("영어:  ");
		student.setEng(sc.nextInt());

		System.out.print("수학:  ");
		student.setMath(sc.nextInt());

		return student;
	}

	public void mainLogic() {

		StudentData studentA = new StudentData();
		StudentData studentB = new StudentData();
		StudentData studentC = new StudentData();
/*		StudentData 클래스의 객체 studentA, studentB, studentC 생성
		studentA, studentB, studentC 객체를 통해 StudentData 클래스의 메소드 사용할 수 있다.
		객체를 통해 클래스의 메소드에 접근하기 위해서는 도트 연산자(.)를 이욯한다.
		static 으로 메소드를 선언하면 객체 생성없이 메소드 호출만으로 가능하다.
		
		객체이름.필드 or 객체이름.메소드 로 접근 가능하다.
		객체이름.필드는 하나의 변수처럼 사용 가능하다.
*/		

		while (true) {

			System.out.println("학생 관리 프로그램");
			System.out.println("*** 1. 등록 *** 2. 이름 목록 *** 3. 평균 *** 4. 1등 학생? *** 5. 종료");
			System.out.print(">>>     ");
			int choice = sc.nextInt();

			if (choice == 1) {
				this.studentA = setScore(studentA);
				this.studentB = setScore(studentB);
				this.studentC = setScore(studentC);
			}

			if (choice == 2) {
				System.out.println(studentA.getName());
				System.out.println(studentB.getName());
				System.out.println(studentC.getName());
			}

			if (choice == 3) {
				studentA.getAvgPrint();
				studentB.getAvgPrint();
				studentC.getAvgPrint();
			}

			if (choice == 4) {
				if (studentA.getAvg() >= studentB.getAvg() && studentA.getAvg() >= studentC.getAvg()) {
					System.out.println(studentA.getName());
				} else if (studentB.getAvg() >= studentC.getAvg() && studentB.getAvg() >= studentA.getAvg()) {
					System.out.println(studentB.getName());
				} else {
					System.out.println(studentC.getName());
				}
			}

			if (choice == 5) {
				System.out.println("프로그램 종료");
				break;
			}

			else {
				System.out.print("다시 입력 >>>     ");
			}
		}
	}
}