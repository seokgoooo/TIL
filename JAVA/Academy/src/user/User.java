package user;

public class User {
	private String id;
	private String password;
	private boolean manager;
	private String favoriteID;
	private String clearID;
	private int age;

	public User(String id, String password, boolean manager, int age) {
		super();
		this.id = id;
		this.password = password;
		this.manager = manager;
		this.favoriteID = id;
		this.clearID = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(String favoriteID) {
		this.favoriteID = favoriteID;
	}

	public String getClearID() {
		return clearID;
	}

	public void setClearID(String clearID) {
		this.clearID = clearID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", manager=" + manager + ", favoriteID=" + favoriteID
				+ ", clearID=" + clearID + ", age=" + age + "]";
	}

}
