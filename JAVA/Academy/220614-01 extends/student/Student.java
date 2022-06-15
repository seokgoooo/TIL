package student;
public class Student {
	private String name;
	private String number;
	private String department;
	private int level;
	private int gradeNumber;
	
	public Student(String name, String number, String department, int level, int gradeNumber) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.level = level;
		this.gradeNumber = gradeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getGradeNumber() {
		return gradeNumber;
	}
	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}
	public String toString() {
		return name + "," + number + "," + department
				+ "," + level + "," + gradeNumber;
	}
}










