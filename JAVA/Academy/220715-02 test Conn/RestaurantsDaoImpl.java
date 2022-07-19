import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.DBUtil;

public class RestaurantsDaoImpl implements RestaurantsDao {
//	(기능) 메소드 하나 만들고 하나 테스트 바로바로 하자
	private Restaurant resultMapping(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String phone = rs.getString("phone");
		String address = rs.getString("address");

		return new Restaurant(id, name, phone, address);
	}

//	배열 이용해서 한꺼번에 Create 메소드 (But 이 방법은 완전하지 않다 반복문 돌아가는 도중 에러 생기면 그 이전의 값은 생성되고 이후의 값은 생성이 안됨)
	public int[] create(List<Restaurant> list) throws SQLException {
		String query = "INSERT INTO restaurants (name, phone, address) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			for (Restaurant r : list) {
				pstmt.setString(1, r.getName());
				pstmt.setString(2, r.getPhone());
				pstmt.setString(3, r.getAddress());
				pstmt.addBatch();
			}

			return pstmt.executeBatch();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@Override
	public int create(String name, String phone, String address) throws SQLException {
//		PreparedStatement를 쓰는 이유
//		1. parameter 자리에 일일히 합연산해주다보니 빡치더라 그래서 VALUES ('이름', '전화번호', '주소') 여기 부분을 ?로 바꿔보자
//		? 로 바꿔주고 PreparedStatement 클래스를 쓰면 ? 값에 원하는 type의 parameter를 넣어줄 수 있다.
//		2. 보안상으로 장점 : parameter에 문자열 값을 집어 넣을 때 문자열 처리를 해서 SQL에 공격을 하는 문자열들 (DROP 등) 을 실행 못하게 막아준다 
		String query = "INSERT INTO restaurants (name, phone, address) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);

			return pstmt.executeUpdate();

		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@Override
	public List<Restaurant> read() throws SQLException {
		String query = "SELECT * FROM restaurants";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Restaurant> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(resultMapping(rs));
			}

		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public Restaurant read(int id) throws SQLException {
		String query = "SELECT * FROM restaurants WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return resultMapping(rs);
			}

		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return null;
	}

	@Override
	public int update(int id, String name, String phone, String address) throws SQLException {
		String query = "UPDATE restaurants SET name = ?, phone = ?, address = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setInt(4, id);

			return pstmt.executeUpdate();

		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@Override
	public int delete(int id) throws SQLException {
		String query = "DELETE FROM restaurants WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			return pstmt.executeUpdate();

		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}
}