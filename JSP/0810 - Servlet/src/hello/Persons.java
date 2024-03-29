package hello;

public class Persons {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String mail;

	public Persons(int id, String firstName, String lastName, int age, String mail) {
		super();
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persons [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", mail="
				+ mail + "]";
	}
}