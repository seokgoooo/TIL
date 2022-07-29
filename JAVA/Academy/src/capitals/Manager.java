package capitals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kr.co.greenart.dbutil.QuizDBUtil;
// 관리자 클래스 CRUD 기능 

public class Manager implements CapitalsDao {
	private Capitals resultMapping(ResultSet rs) throws SQLException {
		int number = rs.getInt("number");
		String question = rs.getString("question");
		String answer = rs.getString("answer");
		String continent = rs.getString("continent");

		return new Capitals(number, question, answer, continent);
	}

	// 음악을 DB에 추가
	@Override
	public void create(int number, String question, String answer, String continent) throws SQLException {
		String query = "Insert Into capitals (number, question, answer, continent) values (?, ?, ?, ?)";
		String mediumQuery = "Insert Into mediumtable (quizType, quiznumber) values (?,?)";

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		try {
			conn = QuizDBUtil.getConnection();
			conn.setAutoCommit(false);

			pstmt1 = conn.prepareStatement(mediumQuery);
			pstmt1.setString(1, "capitals");
			pstmt1.setInt(2, number);
			pstmt1.executeUpdate();

			pstmt2 = conn.prepareStatement(query);
			pstmt2.setInt(1, number);
			pstmt2.setString(2, question);
			pstmt2.setString(3, answer);
			pstmt2.setString(4, continent);
			pstmt2.executeUpdate();

			conn.commit();

		} catch (

		SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			QuizDBUtil.closePstmt(pstmt1);
			QuizDBUtil.closePstmt(pstmt2);
			QuizDBUtil.closeConn(conn);
		}

	}

	// read 목록전체
	@Override
	public List<Capitals> read() throws SQLException {
		String query = "SELECT * FROM Capitals";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Capitals> list = new ArrayList<>();

		try {
			conn = QuizDBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				list.add(resultMapping(rs));

			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(stmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	// 업데이트
	@Override
	public int update(int number, String question, String answer, String continent) throws SQLException {
		String query = "UPDATE Capitals Set question = ?, answer = ?, continent = ? Where number = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			pstmt.setString(2, answer);
			pstmt.setString(3, continent);
			pstmt.setInt(4, number);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

	}

	// 음악 삭제
	@Override
	public int delete(int number) throws SQLException {
		String query = "DELETE FROM mediumtable where quiznumber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, number);

			return pstmt.executeUpdate();

		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	// 하나불러오기
	@Override
	public Capitals read(int number) throws SQLException {
		String query = "select * from capitals where number = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, number);

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
}
