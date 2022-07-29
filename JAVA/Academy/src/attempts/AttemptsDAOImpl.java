package attempts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.QuizDBUtil;

public class AttemptsDAOImpl implements AttemptsDAO {

	private AttemptsQuiz resultMapping(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		int quizNumber = rs.getInt("quiznumber");
		int attemptsCount = rs.getInt("attemptsCount");
		boolean clear = rs.getBoolean("clear");
		return new AttemptsQuiz(id, quizNumber, attemptsCount, clear);
	}

	@Override
	public int create(String id, int quizNumber) throws SQLException {
		String query = "INSERT INTO attemptsquiz (id, quizNumber) values (?, ?)";
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
	public AttemptsQuiz read(String id, int quizNumber) throws SQLException {
		String query = "SELECT * FROM attemptsquiz WHERE id = ? and quizNumber = ?";
		AttemptsQuiz aq = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, quizNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				aq = resultMapping(rs);
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return aq;
	}
	
	@Override
	public int delete(String id, int quizNumber) throws SQLException {
		String query = "DELETE FROM attemptsquiz WHERE id = ? and quizNumber = ?";
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
	public int updateCount(String id, int quizNumber, int attemptsCount) throws SQLException {
		String query = "UPDATE attemptsquiz SET attemptsCount = ? WHERE id = ? and quizNUmber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		attemptsCount++;
		
		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, attemptsCount);
			pstmt.setString(2, id);
			pstmt.setInt(3, quizNumber);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

	}

	@Override
	public int updateClear(String id, int quizNumber, boolean clear) throws SQLException {
		String query = "UPDATE attemptsquiz SET clear = ? WHERE id = ? and quizNUmber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, clear);
			pstmt.setString(2, id);
			pstmt.setInt(3, quizNumber);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	@Override
	public List<Integer> MusicClearRead(String id, boolean clear) throws SQLException {
		String query = "SELECT quiznumber FROM attemptsquiz WHERE (id = ? and clear = ?) and quiznumber between 3000 and 4000 ";
		List<Integer> list = new ArrayList<>();
		
		System.out.println(list);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setBoolean(2, true);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quiznumber"));
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	@Override
	public List<Integer> fourClearRead(String id, boolean clear) throws SQLException {
		String query = "SELECT quiznumber FROM attemptsquiz WHERE (id = ? and clear = ?) and quiznumber between 2000 and 2999 ";
		List<Integer> list = new ArrayList<>();
		
		System.out.println(list);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setBoolean(2, true);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quiznumber"));
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	@Override
	public List<Integer> capitalClearRead(String id, boolean clear) throws SQLException {
		String query = "SELECT quiznumber FROM attemptsquiz WHERE (id = ? and clear = ?) and quiznumber between 1000 and 1999 ";
		List<Integer> list = new ArrayList<>();
		
		System.out.println(list);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setBoolean(2, true);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getInt("quiznumber"));
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	

}
