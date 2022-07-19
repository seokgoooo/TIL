import java.sql.SQLException;
import java.util.Arrays;

public class TestRestaurantsDao {
	public static void main(String[] args) {
		RestaurantsDao dao = new RestaurantsDaoImpl();

		try {
//			Create Test
//			int result = dao.create("테스트중1", "1234-5555", "부산 어쩌구");
//			System.out.println(result == 1);

//			Read Test
//			System.out.println(dao.read());
//			System.out.println(dao.read(1));

//			Update Test
//			int result = dao.update(1, "대대모골", "9874-1355", "부산진구");
//			System.out.println(result == 1);
//			System.out.println(dao.read(1));

//			Delete Test
//			int result = dao.delete(4);
//			System.out.println(result == 1);
//			System.out.println(dao.read());

//			배열 이용해서 한꺼번에 Test
			RestaurantsDaoImpl impl = (RestaurantsDaoImpl) dao;
			int[] result = impl.create(Arrays.asList(new Restaurant(0, "배치6", "6666", "배치주소6"),
					new Restaurant(0, "배치7", "7777", "배치주소7"), new Restaurant(0, "배치9", "3333", "배치주소9"),
					new Restaurant(0, "배치8", "8888", "배치주소8"), new Restaurant(0, "배치10", "5555", "배치주소10")));
			System.out.println(Arrays.toString(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}