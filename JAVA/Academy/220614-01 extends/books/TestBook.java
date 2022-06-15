package books;
public class TestBook {
	public static void main(String[] args) {
		Book b = new Book("그냥책", 50, "그냥작가");
		if (b instanceof Magazine) {
			Magazine m = (Magazine) b;
		}
		
//		Book book = new Magazine("맥심", 100, "커피", "2022-06-01");
//		System.out.println(book.getTitle());
//		System.out.println(book.getPages());
//		System.out.println(book.getAuthor());
//		
//		Magazine magazine = (Magazine) book;
//		System.out.println(magazine.getPublishDate());
		
//		Book b = new Book("파워 자바", 200, "천인국");
//		System.out.println(b.getTitle());
//		System.out.println(b.getPages());
//		System.out.println(b.getAuthor());
//		
//		Magazine m = new Magazine("맥심", 100, "커피", "2022-06-01");
//		System.out.println(m.getTitle());
//		System.out.println(m.getPages());
//		System.out.println(m.getAuthor());
//		System.out.println(m.getPublishDate());
		
//		
	}
}
