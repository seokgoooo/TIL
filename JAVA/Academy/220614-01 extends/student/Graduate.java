package student;
public class Graduate extends Student {
	private String assistantType;
	private double scholarshipRate;
	
	public Graduate(String name, String number, String department, int level, int gradeNumber, String assistantType,
			double scholarshipRate) {
		super(name, number, department, level, gradeNumber);
		this.assistantType = assistantType;
		this.scholarshipRate = scholarshipRate;
	}

	public String getAssistantType() {
		return assistantType;
	}

	public void setAssistantType(String assistantType) {
		this.assistantType = assistantType;
	}

	public double getScholarshipRate() {
		return scholarshipRate;
	}

	public void setScholarshipRate(double scholarshipRate) {
		this.scholarshipRate = scholarshipRate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + assistantType + "," + scholarshipRate;
	}
}
