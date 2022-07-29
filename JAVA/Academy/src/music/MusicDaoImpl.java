package music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.QuizDBUtil;

public class MusicDaoImpl implements MusicDao {

	// 음악 매핑
	private Music resultMapping(ResultSet rs) throws SQLException {
		int n = rs.getInt("number");
		String title = rs.getString("question");
		String singer = rs.getString("singer");
		String genre = rs.getString("genre");
		int year = rs.getInt("year");
		int playCount = rs.getInt("playcount");

		return new Music(n, title, singer, genre, year, playCount);
	}

	// 음악을 DB에 추가
	@Override
	public void create(String title, String singer, String genre, int year) throws SQLException {
		String query = "Insert Into music (number,question, singer, genre, year) values (?, ?, ?, ?, ?)";
		String mediumQuery = "Insert Into mediumtable (quizType, quiznumber) values (?,?)";
		String select = "SELECT number from music order by number desc limit 1";

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			conn.setAutoCommit(false);

			pstmt3 = conn.prepareStatement(select);
			rs = pstmt3.executeQuery();

			int number = 0;

			if (rs.next()) {
				number = rs.getInt("number");
				number++;
				System.out.println(number);

				pstmt1 = conn.prepareStatement(mediumQuery);
				pstmt1.setString(1, "music");
				pstmt1.setInt(2, number);
				pstmt1.executeUpdate();

				pstmt2 = conn.prepareStatement(query);
				pstmt2.setInt(1, number);
				pstmt2.setString(2, title);
				pstmt2.setString(3, singer);
				pstmt2.setString(4, genre);
				pstmt2.setInt(5, year);
				pstmt2.executeUpdate();

				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt1);
			QuizDBUtil.closePstmt(pstmt2);
			QuizDBUtil.closePstmt(pstmt3);
			QuizDBUtil.closeConn(conn);
		}

	}

	// 음악 목록 전체
	@Override
	public List<Music> read() throws SQLException {
		String query = "Select * from music";
		List<Music> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(resultMapping(rs));
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return list;
	}

	// 음악 하나 불러오기
	@Override
	public Music read(int number) throws SQLException {
		String query = "Select * from music where number = ?";
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

	// 음악 수정
	@Override
	public int update(int number, String title, String singer, String genre, int year) throws SQLException {
		String query = "Update music Set question = ?, singer = ?, genre = ?, year = ? where number = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, singer);
			pstmt.setString(3, genre);
			pstmt.setInt(4, year);
			pstmt.setInt(5, number);

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

	// play횟수 증가
	@Override
	public int playCountPlus(int number, int playCount) throws SQLException {
		String query = "UPDATE music SET playcount = ? where number = ?";
		playCount++;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, playCount);
			pstmt.setInt(2, number);

			return pstmt.executeUpdate();

		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}
}
