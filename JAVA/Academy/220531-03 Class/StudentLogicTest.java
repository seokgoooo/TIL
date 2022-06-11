public class StudentLogicTest {
	public static void main(String[] args) {
		StudentLogic run = new StudentLogic();	// StudentLogic 클래스의 객체 a 생성
		/*
		 * int n에서 n이 int의 자료형이라는 말처럼 ---> run이 StudentLogic 클래스의 자료형이다.
		 * run 객체에는 StudentLogic 클래스로 생성한 객체만 대입할 수 있다.
		 * run 객체에는 StudentLogic 자료형에 해당하는 값만 담을 수 있다.
		 *
		 * <<< 객체(Object) 와 인스턴스(instance) 의 차이 >>>
		 * object - 목적, 대상, 물건 = purpose, aim, stuff
		 * instance - 사례, 예, 경우 = example, case
		 * run 이라는 객체(object)는 StudentLogic 클래스의 인스턴스(instance) 이다.
		 * 
		 * 인스턴스라는 말은 특정 객체(run)가 어떤 클래스(StudentLogic)의 객체인지를 관계위주로 설명할 때 사용된다.
		 * 'run은 인스턴스'라는 말 보다 'run은 객체'
		 * 'run은 StudentLogic의 객체'라는 말 보다 'run은 StudentLogic의 인스턴스'라는 표현이 더 잘어울림.
		 * 
		 */
		run.mainLogic();	// static 으로 선언되지 않았기 때문에 객체를 통해 mainLogic 메소드를 호출
	}
}

/*
 * 학생 관리 프로그램
 * 콘솔 입출력
 * 반에 학생을 등록. 3명 
 * 이름 목록을 볼 수 있어야 하고
 * 평균을 볼 수 있고
 * 1등 학생의 정보도 볼 수 있는 프로그램.
 * 자유롭게
 * 
 * 기존에 만들었던 클래스 << 수정. 수정을 해야하는 이유와 전 후가 어떻게 바뀌었는지 '다 기록'
 * 
 * 
 * 
 * 학급(반)
 * 학생1
 * 학생2
 * 학생3
 * 
 * 1. 3명의 학생의 이름을 콘솔에 출력할 수 있음.
 * 2. 학생 3명의 총 평균을 알려줄 수 있음.
 * 3. 평균점수가 가장 높은
 * 학생(참조)을 알려줄 수 있음. => 동일 점수일 경우 1, 2, 3 순
 */