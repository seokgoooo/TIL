package favorite;

public class FavoritesQuiz {
	private String id;
	private int quizNumber;

	public FavoritesQuiz(String id, int quizNumber) {
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

	@Override
	public String toString() {
		return "FavoritesQuiz [id=" + id + ", quizNumber=" + quizNumber + "]";
	}

}
