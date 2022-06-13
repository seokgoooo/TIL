package Page264Four;

class Book {
	private String title;
	private int pages;
	private String author;
	
	public Book(String title, int pages, String author) {
		this.title = title;
		this.pages = pages;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return "제목: " + title + ", 페이지수: " + pages + ", 저자: " + author;
	}
}
