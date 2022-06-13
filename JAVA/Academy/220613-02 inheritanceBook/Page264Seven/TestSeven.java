package Page264Seven;

/*
 * 7. 다음 그림에 해당하는 클래스를 작성하여 보자
 * 모든 학생은 이름, 학번, 소속 학과, 학년, 이수 학점 수를 가진다.
 * 추가적으로 학부생은 소속 동아리명을 가지고 있고
 * 대학원생은 조교 유형과 장학금 비율을 가진다.
 * 조교 유형에는 교육 조교와 연구 조교가 있으며 장학금 비율은 0과 1 사이의 값이다.
 * 각 클래스는 적절한 생성자 메소드, 접근자 메소드, 변경자 메소드를 가진다.
 * 이러한 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하랴
 * 				Student
 * 			/			\
 * UnderGraduate		Graduate
 */

public class TestSeven {
	public static void main(String[] args) {
		Student one = new Student("이름", 33, "전공", 1, 5);
		System.out.println(one.toString());
		
		Graduate two = new Graduate("ㅇㅇ", 23, "major", 3, 44, "연구", 0.1);
		System.out.println(two.toString());
		
		UnderGraduate three = new UnderGraduate("name", 22, "major", 6, 88, "club");
		System.out.println(three.toString());
	}
}