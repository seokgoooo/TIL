package sec01.exam06;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
//		Math.random()은 0.0 ~ 1.0 실수를 가져옴.
		int time = (int) (Math.random() * 4) + 8;
		System.out.println("[현재 시각: " + time + " 시]");
		
		switch(time){
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:		//default는 생략가능하다.
			System.out.println("외근을 나갑니다.");
		}
	}
}