package kr.co.greenart;

import java.util.List;

public class BoardDTO {
	private List<Article> list;
	private int totalPage;

	public BoardDTO() {
	}

	public BoardDTO(List<Article> list, int totalPage) {
		super();
		this.list = list;
		this.totalPage = totalPage;
	}

	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + totalPage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [list=" + list + ", totalPage=" + totalPage + "]";
	}
}