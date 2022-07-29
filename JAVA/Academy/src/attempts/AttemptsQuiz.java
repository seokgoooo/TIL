package attempts;

public class AttemptsQuiz {
	private String id;
	private int quizNumber;
	private int attemptsCount;
	private boolean clear;

	public AttemptsQuiz(String id, int quizNumber, int attemptsCount, boolean clear) {
		this.id = id;
		this.quizNumber = quizNumber;
		this.attemptsCount = attemptsCount;
		this.clear = clear;
	}

	public AttemptsQuiz(String id, int quizNumber) {
		this.id = id;
		this.quizNumber = quizNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(int quizNumber) {
		this.quizNumber = quizNumber;
	}

	public int getAttemptsCount() {
		return attemptsCount;
	}

	public void setAttemptsCount(int attemptsCount) {
		this.attemptsCount = attemptsCount;
	}

	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}

	@Override
	public String toString() {
		return "AttemptsQuiz [id=" + id + ", quizNumber=" + quizNumber + ", attemptsCount=" + attemptsCount + ", clear="
				+ clear + "]";
	}

}
