package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.QuizDBUtil;

public class UserDaoImpl implements UserDao {

	// User 맵핑
	private User resultMapping(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String password = rs.getString("password");
		boolean manager = rs.getBoolean("manager");
		int age = rs.getInt("age");

		return new User(id, password, manager, age);
	}

	// user 생성
	@Override
	public int create(String id, String password, boolean manager, int age) throws SQLException {
		String query = "INSERT INTO USER (id, password, manager, favorites_id, clear_id, age) values (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setBoolean(3, manager);
			pstmt.setString(4, id);
			pstmt.setString(5, id);
			pstmt.setInt(6, age);
			return pstmt.executeUpdate();

		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

	}

	// 모든 회원 불러오기
	@Override
	public List<User> read() throws SQLException {
		String query = "SELECT * FROM USER";
		List<User> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = resultMapping(rs);
				list.add(user);
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	// 특정 회원 불러오기
	@Override
	public User read(String id) throws SQLException {
		String query = "SELECT * FROM USER WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return resultMapping(rs);
			} else {
				return null;
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

	}

	// 회원 정보 수정
	@Override
	public int update(String id, String password, boolean manager, int age) throws SQLException {
		String query = "UPDATE USER SET password = ?, manager = ?, age = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setBoolean(2, manager);
			pstmt.setInt(3, age);
			pstmt.setString(4, id);

			return pstmt.executeUpdate();

		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	// 회원 삭제
	@Override
	public int delete(String id) throws SQLException {
		String query = "DELETE FROM USER WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

}
