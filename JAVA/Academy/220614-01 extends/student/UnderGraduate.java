package student;

public class UnderGraduate extends Student {
	private String clubName;

	public UnderGraduate(String name, String number, String department, int level, int gradeNumber, String clubName) {
		super(name, number, department, level, gradeNumber);
		this.clubName = clubName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + clubName;
	}
}
