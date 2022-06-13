package Page259;

public class Human {
	private String name;
	private int age;
	private String profession;
		
	public Human(String name, int age, String profession) {
		this.name = name;
		this.age = age;
		this.profession = profession;
	}
	
	public String toString() {
		return "이름: " + name + ", " + "나이: " + age + "세";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		Human one = new Human("춘향", 18, "직업");
		Human two = new Human("몽룡", 21, "직업");
		Human three = new Human("사또", 50, "직업");
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
}
