package Page259;

public class Student extends Human {
	private String major;

	public Student(String name, int age, String profession, String major) {
		super(name, age, profession);
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + this.getProfession() + ", 전공: " + major;
	}

	@Override
	public String getProfession() {
		return ", 직업: 학생";
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public static void main(String[] args) {
		Student student1 = new Student("명진", 21, "", "컴퓨터");
		Student student2 = new Student("미현", 22, "","경영");
		Student student3 = new Student("용준", 24, "","경제");
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student3.toString());
	}
}
