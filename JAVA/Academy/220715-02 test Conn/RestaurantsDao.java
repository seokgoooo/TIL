import java.sql.SQLException;
import java.util.List;

public interface RestaurantsDao {
//	Data access object : DB에 대한 접근을 전담하는 객체
//	추상 데이터 소스를 통해 데이터 접근의 투명성을 보장하는 기능이다.
//	why? 데이터에 직접 액세스 할 때 발생하는 문제는 데이터 소스가 변경 될 수 있기 때문에
//		데이터 리소스의 클라이언트 인터페이스와 데이터 액세스 메커니즘을 분리하는 것입니다.

//	 restaurants 테이블에 대한 db access를 수행하는 객체를 작성해보세요. 작성 후 테스트!!
//	  메소드(입력값) : 반환값									throws 예외

//	 *** 메소드 헤더만 있고 반환값이 있는걸 보니 추상화시켜서 인터페이스를 만들고 싶다. ***
//	 C(상호명, 전화번호, 주소) or C(음식점) : 행 개수 				throws SQLException
	int create(String name, String phone, String address) throws SQLException;

//	 R() : List<음식점> 									throws SQLException
	List<Restaurant> read() throws SQLException;

//	 R(pk) : 음식점											throws SQLException
	Restaurant read(int id) throws SQLException;

//	 U(pk, 새 상호명, 새 전화번호, 새 주소) or U(음식점) : 행 개수 	throws SQLException
	int update(int id, String name, String phone, String address) throws SQLException;

//	 D(pk) : 행 개수 										throws SQLException
	int delete(int id) throws SQLException;
}