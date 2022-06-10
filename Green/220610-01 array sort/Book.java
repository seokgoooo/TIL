public class Book {
	private String title;
	private String author;
	private String publisher;
	private String type;
	private int price;
	
	public Book() {
	}

	public Book(String title, String author, String publisher, String type, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.type = type;
		this.price = price;
	}
	
	public void printBook() {
		System.out.printf("%s / %s / %s / %s / %d원", title, author, publisher, type, price);
	}
	
	public void printSummary() {
		System.out.printf("%s / %d원", title, price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}