import java.util.Scanner;

public class Logic {
	Scanner sc = new Scanner(System.in);
	private Score stu1;
	private Score stu2;
	private Score stu3;

	public Logic(Score stu1, Score stu2, Score stu3) {
		this.stu1 = stu1;
		this.stu2 = stu2;
		this.stu3 = stu3;
	}

	public Logic() {
		/*
		 * 생성자(Constructor) : 메소드명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메소드 생성자의 규칙 1. 클래스명과
		 * 메소드명이 동일하다. 2. 리턴타입을 정의하지 않는다. (void도 사용하지 않는다)
		 * 
		 * 생성자는 객체가 생성될 때 호출된다. 즉, new 키워드가 사용될 때 호출된다. 생성자를 사용하면 필수적인 행동을 객체 생성시에 제어할 수
		 * 있다.
		 * 
		 * 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 디폴트 생성자를 추가한다. 하지만 사용자가 작성한 생성자가 하나라도 구현되어 있다면
		 * 컴파일러는 디폴트 생성자를 추가하지 않는다.
		 */
	}

	public Score setScore(Score stu) {
		System.out.print("반:  ");
		stu.setClassNum(sc.nextInt());
		System.out.println();

		System.out.print("학생 이름:  ");
		sc.nextLine();
		stu.setName(sc.nextLine());
		System.out.println();

		System.out.print("국어:  ");
		stu.setKor(sc.nextInt());
		System.out.println();

		System.out.print("영어:  ");
		stu.setEng(sc.nextInt());
		System.out.println();

		System.out.print("수학:  ");
		stu.setMath(sc.nextInt());
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
			int choice = sc.nextInt();

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
				System.out.println("프로그램 종료");
				break;
			}

			else {
				System.out.print("다시 입력 >>>     ");
			}
		}
	}
}