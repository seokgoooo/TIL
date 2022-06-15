package books;

public class Main2 {
	public static void main(String[] args) {
		Novel novel = new Novel("소설책", 100, "소설작가", 10);
		Magazine m = new Magazine("잡지", 90, "잡지작가", "2022-06-01");
		
		Book book = novel;
		novel.getRating();
//		book.getRating();
		
		if (book instanceof Magazine) {
			Magazine otherRef = (Magazine) book;
			otherRef.getPublishDate();
		} else if (book instanceof Novel) {
			Novel nnn = (Novel) book;
			nnn.getRating();
		}
	}
}
