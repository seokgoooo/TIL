package Page264Seven;

class UnderGraduate extends Student {
	private String club;

	public UnderGraduate(String name, int id, String major, int grade, int credit, String club) {
		super(name, id, major, grade, credit);
		this.club = club;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	public String toString() {
		return super.toString() + ", 동아리: " + club;
	}
}