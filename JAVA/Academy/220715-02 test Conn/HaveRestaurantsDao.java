//	레스토랑 로직을 가지고 있는 객체
public class HaveRestaurantsDao {
	private RestaurantsDao dao;

	public HaveRestaurantsDao(RestaurantsDao dao) {
		super();
		this.dao = dao;
	}

	public void setDao(RestaurantsDao dao) {
		this.dao = dao;
	}

	public void logic1() {
		// 로직 흐름
		// dao.메소드호출();
	}
}