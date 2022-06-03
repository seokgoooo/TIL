import java.util.ArrayList;
import java.util.Scanner;

public class StudentEx {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();

//		System.out.println("list 크기 : " + stlist.size());
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("감자고 성적 관리 프로그램");
			System.out.println("1.입력  2.출력  3.종료");
			System.out.print(">   ");
			int choice = sc.nextInt();

			if (choice == 1) {

				// 정보를 담을 Student 객체 생성
				Student s = new Student();

				// setter를 통안 데이터 입력.
				System.out.print("학생이름 : ");
				sc.nextLine();
				s.setName(sc.nextLine());

				System.out.print("국어 : ");
				s.setKor(sc.nextInt());

				System.out.print("영어 : ");
				s.setEng(sc.nextInt());

				System.out.print("수학 : ");
				s.setMath(sc.nextInt());

				// 이렇게 데이터가 담긴 객체를 list에 추가해주면 된다.
				list.add(s);

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
		sc.close();
	}
}