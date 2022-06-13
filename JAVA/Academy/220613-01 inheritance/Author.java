
public class Author extends Person {
	private String bookList;

	public Author(String name, int age, String bookList) {
		super(name, age);
		this.bookList = bookList;
	}

	public String getBookList() {
		return bookList;
	}
}
