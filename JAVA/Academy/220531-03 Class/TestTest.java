//학급(반) 학생	학생	학생
//1. 3명의 학생의 이름을 콘솔에 출력할 수 있음.
//2. 학생 3명의 총 평균을 알려줄 수 있음.
//3. 평균점수가 가장 높은 학생(참조)을 알려줄 수 있음. => 동일점수

public class TestTest {
	public static void main(String[] args) {
		Test student1 = new Test("학생1", 100, 95, 90);
		Test student2 = new Test("학생2", 85, 75, 70);
		Test student3 = new Test("학생3", 80, 55, 60);
		
		String name1 = student1.getName();
		System.out.println(name1);
		double avg1 = student1.getAverage();
		System.out.println(avg1);
		
		String name2 = student2.getName();
		System.out.println(name2);
		double avg2 = student2.getAverage();
		System.out.println(avg2);
		
		String name3 = student3.getName();
		System.out.println(name3);
		double avg3 = student3.getAverage();
		System.out.println(avg3);
		
		if (avg1 > avg2 && avg1 > avg3) {
			System.out.println(name1);
		} else if (avg2 > avg1 && avg2 > avg3) {
			System.out.println(name2);
		} else {
			System.out.println(name3);
		}
	}
}