// 상속

// 학생
// 이름
// 나이
// 점수

// 이름 알려주기
// 점수 알려주기 

// 작가
// 이름
// 나이
// 작품 목록

// 이름 알려주기
// 작품 목록 알려주기

public class Main {
	public static void main(String[] args) {
		Person p = new Person("사람이름", 22);

		Student s = new Student("학생이름", 17, 90);
		System.out.println(s.getName());
		System.out.println(s.getScore());
		System.out.println(s.getAge());

//		p.getScore();

		Author a = new Author("작가이름", 30, "반지의길");
		System.out.println(a.getName());
		System.out.println(a.getBookList());
		System.out.println(a.getAge());
	}
}
