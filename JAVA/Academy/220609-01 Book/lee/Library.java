import java.util.Arrays;
import java.util.Scanner;

public class Library {
	private Book[] books;

	public Library(Book... books) {
		this.books = books;
	}

	// 1번. 가격순 정렬
	public Book[] getDownSeq() {
		Book temp = new Book();
		for (int i = 0; i < books.length - 1; i++) {
			for (int j = i + 1; j < books.length; j++) {
				if (books[i].getPrice() < books[j].getPrice()) {
					temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				} else if (books[i].getPrice() == books[j].getPrice()) {
					if (books[i].getTitle().length() < books[j].getTitle().length()) {
						temp = books[i];
						books[i] = books[j];
						books[j] = temp;
					}
				}
			}
		}
		return books;
	}

	public Book[] getUpSeq() {
		Book temp = new Book();
		for (int i = 0; i < books.length - 1; i++) {
			for (int j = i + 1; j < books.length; j++) {
				if (books[i].getPrice() > books[j].getPrice()) {
					temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				} else if (books[i].getPrice() == books[j].getPrice()) {
					if (books[i].getTitle().length() > books[j].getTitle().length()) {
						temp = books[i];
						books[i] = books[j];
						books[j] = temp;
					}
				}
			}
		}
		return books;
	}

	public void printSeq() {
		Scanner scan = new Scanner(System.in);

		int input;
		while (true) {
			System.out.println("1번");
			System.out.println("다음 중 선택하시오. (1번:내림차순, 2번:오름차순)");
			input = scan.nextInt();
			if (input == 1 || input == 2) {
				break;
			}
			System.out.println("잘못입력하셨습니다.");
		}
		switch (input) {
		case 1:
			for (Book b : getDownSeq()) {
				System.out.printf("%s / %d원\n", b.getTitle(), b.getPrice());
			}
			break;
		case 2:
			for (Book b : getUpSeq()) {
				System.out.printf("%s / %d원\n", b.getTitle(), b.getPrice());
			}
			break;
		}

	}

	// 2번. 분야별
	public void searchType() {
		Scanner scan = new Scanner(System.in);
		Book[] temp;
		int count = 0;
		String search;

		while (true) {
			System.out.print("원하시는 분야를 입력해주세요: (장편소설 / 시집 / 과학 공학 / 에세이)");
			search = scan.nextLine();

			for (int i = 0; i < books.length; i++) {
				if (books[i].getType().equals(search)) {
					count++;
				}
			}
			if (count > 0) {
				break;
			}
			System.out.println("없는 분야입니다. 다시 검색해주세요.");
		}

		temp = new Book[count];
		int num = 0;
		for (int i = 0; i < books.length; i++) {
			if (books[i].getType().equals(search)) {
				temp[num] = books[i];
				num++;
			}
		}

		for (Book b : temp) {
			System.out.printf("%s / %s\n", b.getTitle(), b.getType());
		}
		System.out.println();
	}

	// 3번. 책 전체
	public void printBooks() {
		for (int i = 0; i < books.length; i++) {
			System.out.print((i + 1) + ".");
			books[i].printBook();
			System.out.println();
		}
	}

	// 3-1번. 책 1권에 대한 상세정보
	public void printDetail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("원하시는 책 제목을 검색해주세요.");
		String searchTitle = scan.nextLine();

		for (int i = 0; i < books.length; i++) {
			if (books[i].getTitle().equals(searchTitle)) {
				books[i].printBook();
			}
		}
		System.out.println();
	}

	// 4번 도서정보 수정
	public Book InputBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("책 제목, 저자, 출판사, 장르, 가격을 입력해주세요.");
		String title = scan.nextLine();
		String author = scan.nextLine();
		String publisher = scan.nextLine();
		String type = scan.nextLine();
		int price = scan.nextInt();

		return new Book(title, author, publisher, type, price);
	}

	public void setBooks() {
		Scanner scan = new Scanner(System.in);

		System.out.println("=====책 목록 =====");
		printBooks();
		System.out.println("수정하실 책을 선택해주세요. (1 ~ )");
		int sel = scan.nextInt();

		books[sel - 1] = InputBook();
	}

	// 5번 도서 추가
	public void addBook() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			books = Arrays.copyOf(books, books.length + 1);
			books[books.length - 1] = InputBook();
			
			int sel;
			do {
				System.out.println("1.더 추가하기, 2.종료");
				sel = scan.nextInt();
			} while(sel != 1 || sel != 2);
			
			if (sel == 2) {
				break;
			} 
		}
	}
}











