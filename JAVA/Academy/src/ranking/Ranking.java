package ranking;

public class Ranking {
	private String title;
	private int ratio;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public Ranking(String title, int ratio) {
		super();
		this.title = title;
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Ranking [title=" + title + ", ratio=" + ratio + "]";
	}

}
