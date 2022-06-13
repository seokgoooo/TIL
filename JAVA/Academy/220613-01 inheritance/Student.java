
public class Student extends Person {
	private int score;

	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}
