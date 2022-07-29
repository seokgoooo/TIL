package fourletters;

public class favorites {
	String id;
	int number;
	public favorites(String id, int number) {
		super();
		this.id = id;
		this.number = number;
	}
	public favorites(String id) {
		super();
		this.id = id;
	}
	public favorites(int number) {
		super();
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
