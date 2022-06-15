package books;

public class Novel extends Book {
	private int rating;

	public Novel(String title, int pages, String author, int rating) {
		super(title, pages, author);
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
