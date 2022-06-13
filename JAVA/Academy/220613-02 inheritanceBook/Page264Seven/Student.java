package Page264Seven;

class Student {
	private String name;
	private int id;
	private String major;
	private int grade;
	private int credit;

	public Student(String name, int id, String major, int grade, int credit) {
		this.name = name;
		this.id = id;
		this.major = major;
		this.grade = grade;
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String toString() {
		return "이름: " + name + ", 학번: " + id + ", 소속학과: " + major + ", 학년: " + grade + ", 이수학점: " + credit;
	}
}