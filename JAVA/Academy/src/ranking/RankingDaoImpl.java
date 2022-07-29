package ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.QuizDBUtil;

public class RankingDaoImpl implements RankingDao {

	private Ranking resultMapping(ResultSet rs) throws SQLException {
		String title = rs.getString("question");
		int ratio = rs.getInt("ratio");
		return new Ranking(title, ratio);
	}

	// 정답률 top5
	@Override
	public List<Ranking> correctRatio(String table) throws SQLException {
		int low, high;
		if (table.equals("music")) {
			low = 3000;
			high = 3999;
		} else if (table.equals("fourletters")) {
			low = 2000;
			high = 2999;
		} else {
			low = 1000;
			high = 1999;
		}
		String query = "call Correct_Ratio(?, ?, ?)";
		List<Ranking> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, low);
			pstmt.setInt(2, high);
			pstmt.setString(3, table);
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

	// 오답률 top5
	@Override
	public List<Ranking> incorrectRatio(String table) throws SQLException {
		int low, high;
		if (table.equals("music")) {
			low = 3000;
			high = 3999;
		} else if (table.equals("fourletters")) {
			low = 2000;
			high = 2999;
		} else {
			low = 1000;
			high = 1999;
		}
		String query = "call inCorrect_Ratio(?, ?, ?)";
		List<Ranking> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, low);
			pstmt.setInt(2, high);
			pstmt.setString(3, table);
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

	// 즐겨찾기 top5
	@Override
	public List<Ranking> favoriteTop(String table) throws SQLException {
		String query = "call favorite_top(?)";
		List<Ranking> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, table);

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

	// 많이푼 순서 top5
	@Override
	public List<Ranking> maxTest(String table) throws SQLException {
		int low, high;
		if (table.equals("music")) {
			low = 3000;
			high = 3999;
		} else if (table.equals("fourletters")) {
			low = 2000;
			high = 2999;
		} else {
			low = 1000;
			high = 1999;
		}

		String query = "call max_test(?, ?, ?)";
		List<Ranking> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, low);
			pstmt.setInt(2, high);
			pstmt.setString(3, table);
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

	// 연령대별 퀴즈 유형 순위
	@Override
	public List<Ranking> ageTop(int age) throws SQLException {
		String query = "call age_best(?)";
		List<Ranking> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, age);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String type = null;
				int typeInt = rs.getInt("typeInt");
				if (typeInt == 3000) {
					type = "음악퀴즈";
				} else if (typeInt == 2000) {
					type = "사자성어";
				} else if (typeInt == 1000) {
					type = "수도퀴즈";
				}
				int attempt = rs.getInt("sum");

				list.add(new Ranking(type, attempt));
			}

		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return list;
	}

	// 종합 순위
	@Override
	public List<Ranking> scoreRank() throws SQLException {
		String query = "select id question, sum(clear) `ratio` from attemptsquiz group by id order by `ratio` desc";
		List<Ranking> list = new ArrayList<>();
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

		}
		return list;
	}

}
