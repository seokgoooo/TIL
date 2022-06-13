package Page264Seven;

public class Graduate extends Student {
	private String type;
	private double scholarship;

	public Graduate(String name, int id, String major, int grade, int credit, String type, double scholarship) {
		super(name, id, major, grade, credit);
		this.type = type;
		this.scholarship = scholarship;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getScholarship() {
		return scholarship;
	}

	public void setScholarship(double scholarship) {
		if (0 <= scholarship && scholarship <= 1) {
			this.scholarship = scholarship;
		} else
			;
	}
	
	public String toString() {
		return super.toString() + "유형: " + type + ", 장학금 비율: " + scholarship;
	}
}