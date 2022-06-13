package Page264Four;

class Magazine extends Book {
	private int date;

	public Magazine(String title, int pages, String author, int date) {
		super(title, pages, author);
		this.date = date;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	public String toString() {
		return super.toString() + "발매일: " + date;
	}
}