package fourletters;

public class dummyUser {
	String id;

	public dummyUser(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "dummyUser [id=" + id + "]";
	}
	
	
}
