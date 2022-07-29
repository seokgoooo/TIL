package favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.QuizDBUtil;

public class FavoritesDAOImpl implements FavoritesDAO {

	// 즐찾에 추가
	@Override
	public int create(String id, int quizNumber) throws SQLException {
		String query = "INSERT INTO favoritesquiz (id, quiznumber) values (?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, quizNumber);
			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}


	// 특정 ID 즐찾 목록 삭제
	@Override
	public int delete(String id, int quizNumber) throws SQLException {
		String query = "DELETE FROM favoritesquiz where id = ? and quiznumber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, quizNumber);
			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	@Override
	public List<Integer> musicRead(String id) throws SQLException {
		String query = "SELECT quiznumber FROM favoritesquiz WHERE id = ? and quiznumber between 3000 and 3999";
		List<Integer> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quizNumber"));
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public List<Integer> fourRead(String id) throws SQLException {
		String query = "SELECT quiznumber FROM favoritesquiz WHERE id = ? and quiznumber between 2000 and 2999";
		List<Integer> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quizNumber"));
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public List<Integer> capitalRead(String id) throws SQLException {
		String query = "SELECT quiznumber FROM favoritesquiz WHERE id = ? and quiznumber between 1000 and 1999";
		List<Integer> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quizNumber"));
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return list;
	}

}
