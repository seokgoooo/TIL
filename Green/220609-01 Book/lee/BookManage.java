import java.util.Scanner;

public class BookManage {
	Library lib;
	
	// 기존 책 목록
	public Book[] nowBooks() {
		Book[] books = new Book[5];
		books[0] = new Book("작별인사", "김영하", "복복서가", "장편소설", 12600);
		books[1] = new Book("불편한 편의점", "김호연", "나무옆의자", "장편소설", 12600);
		books[2] = new Book("지금 알고 있는 걸 그때도 알았더라면", "류시화", "열림원", "시집", 8100);
		books[3] = new Book("코스모스", "칼 세이건", "사이언스북스", "과학 공학", 16650);
		books[4] = new Book("여행의 이유", "김영하", "문학동네", "에세이", 12150);
		return books;
	}
	
	public void Start() {
		Scanner scan = new Scanner(System.in);
		
		// 기존 책 정보 등록
		lib = new Library(nowBooks());

		System.out.println("도서관리 프로그램입니다.");
		System.out.println();
		while(true) {
			System.out.println();
			System.out.println("=====목록 보기=====");
			System.out.println("1. 가격순으로(내림차순, 오름차순 선택가능)");
			System.out.println("2. 분야를 선택해서 해당 분야만 보기");
			System.out.println("3. 상세보기");
			System.out.println("4. 도서 정보 수정");
			System.out.println("5. 도서 정보 추가");
			System.out.println("6. 프로그램종료");
			System.out.print("원하시는 기능을 입력해주세요: ");
			int input = scan.nextInt();
			
			switch (input) {
			case 1:
				lib.printSeq();
				break;
			case 2:
				lib.searchType();
				break;
			case 3:
				lib.printDetail();
				break;
			case 4:
				lib.setBooks();
				break;
			case 5:
				lib.addBook();
				break;
			case 6:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못된 입력입니다. \n");
				break;
			}
		}
	}
}
