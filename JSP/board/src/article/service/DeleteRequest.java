package article.service;

public class DeleteRequest {
	private int articleNumber;

	public DeleteRequest(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getArticleNumber() {
		return articleNumber;
	}
}