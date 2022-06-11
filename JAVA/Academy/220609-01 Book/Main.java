import java.util.Arrays;
import java.util.Scanner;

/*
	도서 관리 프로그램
	목록 보기
 	1. 가격순으로(오름차순, 내림차순 선택가능)
 	2. 분야를 선택해서 해당 분야만 보기

 	1. 작별인사 						/ 김영하 		/ 복복서가 	/ 장편소설	 	/ 12,600원
 	2. 불편한 편의점 					/ 김호연 		/ 나무옆의자 	/ 장편소설		/ 12,600원
 	3. 지금 알고 있는 걸 그때도 알았더라면 		/ 류시화 		/ 열림원 		/ 시집 		/ 8,100원
 	4. 코스모스						/ 칼 세이건 	/ 사이언스북스 	/ 과학 공학 	/ 16,650원
 	5. 여행의 이유						/ 김영하 		/ 문학동네 	/ 에세이	 	/ 12,150원
 	
 	-----
 	3. 상세보기
 	4. 도서 정보 수정
	5. 도서 정보 추가
*/
public class Main {
	public static void main(String[] args) {
		final int NUM_BOOKS = 5;
		BookData[] numbers = new BookData[NUM_BOOKS];
		numbers[0] = new BookData("작별인사", "김영하", "복복서가", "장편소설", 12600);
		numbers[1] = new BookData("불편한 편의점", "김호연", "나무옆의자", "장편소설", 12600);
		numbers[2] = new BookData("지금 알고 있는 걸 그때도 알았더라면", "류시화", "열림원", "시집", 8100);
		numbers[3] = new BookData("코스모스", "칼 세이건", "사이언스북스", "과학 공학", 16650);
		numbers[4] = new BookData("여행의 이유", "김영하", "문학동네", "에세이", 12150);

		BookData run = new BookData();

		while (true) {
			Scanner scan = new Scanner(System.in);
			run.printMainView();
			int choice = scan.nextInt();
			if (choice == 0) {
				run.exit();
				break;
			} else if (choice == 1) {

				System.out.println("오름차순 정렬");

				int[] numbersCopy = new int[NUM_BOOKS];
				for (int i = 0; i < NUM_BOOKS; i++) {
					numbersCopy[i] = numbers[i].getPrice();
				}

				Arrays.sort(numbersCopy);
				System.out.println(Arrays.toString(numbersCopy));

				for (int i = 0; i < NUM_BOOKS; i++) {
					System.out.println("[ 제목: " + numbers[i].getName() + " // 가격: " + numbers[i].getPrice() + " ]");
				}
				System.out.println("[ 제목: " + numbers[2].getName() + " // 가격: " + numbers[2].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[4].getName() + " // 가격: " + numbers[4].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[0].getName() + " // 가격: " + numbers[0].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[1].getName() + " // 가격: " + numbers[1].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[3].getName() + " // 가격: " + numbers[3].getPrice() + " ]");

			} else if (choice == 2) {
				System.out.println("내림차순 정렬");

				int[] numbersCopy = new int[NUM_BOOKS];
				for (int i = 0; i < NUM_BOOKS; i++) {
					numbersCopy[i] = numbers[i].getPrice();
				}

				Arrays.sort(numbersCopy);

				for (int i = numbersCopy.length - 1; i >= 0; i--) {
					System.out.println(numbersCopy[i]);
				}

				for (int i = NUM_BOOKS - 1; i >= 0; i--) {
					System.out.println("[ 제목: " + numbers[i].getName() + " // 가격: " + numbers[i].getPrice() + " ]");
				}
				System.out.println("[ 제목: " + numbers[3].getName() + " // 가격: " + numbers[3].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[1].getName() + " // 가격: " + numbers[1].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[0].getName() + " // 가격: " + numbers[0].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[4].getName() + " // 가격: " + numbers[4].getPrice() + " ]");
				System.out.println("[ 제목: " + numbers[2].getName() + " // 가격: " + numbers[2].getPrice() + " ]");

			} else if (choice == 3) {
				System.out.println("1. 장편소설");
				System.out.println("2. 시집");
				System.out.println("3. 과학 공학");
				System.out.println("4. 에세이");
				System.out.println("0. 초기 화면으로");
				int inputGroupNumber = scan.nextInt();
				if (inputGroupNumber == 1) {
					for (int i = 0; i < NUM_BOOKS; i++) {
						if (numbers[i].getGroup().equals("장편소설")) {
							System.out.println(
									"[ 제목: " + numbers[i].getName() + " // 분야: " + numbers[i].getGroup() + " ]");
						}
					}
				} else if (inputGroupNumber == 2) {
					for (int i = 0; i < NUM_BOOKS; i++) {
						if (numbers[i].getGroup().equals("시집")) {
							System.out.println(
									"[ 제목: " + numbers[i].getName() + " // 분야: " + numbers[i].getGroup() + " ]");
						}
					}
				} else if (inputGroupNumber == 3) {
					for (int i = 0; i < NUM_BOOKS; i++) {
						if (numbers[i].getGroup().equals("과학 공학")) {
							System.out.println(
									"[ 제목: " + numbers[i].getName() + " // 분야: " + numbers[i].getGroup() + " ]");
						}
					}
				} else if (inputGroupNumber == 4) {
					for (int i = 0; i < NUM_BOOKS; i++) {
						if (numbers[i].getGroup().equals("에세이")) {
							System.out.println(
									"[ 제목: " + numbers[i].getName() + " // 분야: " + numbers[i].getGroup() + " ]");
						}
					}
				} else {
					run.exit();
					break;
				}
			}
		}

	}
}