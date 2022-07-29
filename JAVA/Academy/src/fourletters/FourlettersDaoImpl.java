package fourletters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import attempts.AttemptsDAOImpl;
import kr.co.greenart.dbutil.QuizDBUtil;

public class FourlettersDaoImpl implements Dao {
	static List<fourletters> list = new ArrayList<fourletters>();
	static List<Integer> favlist = new ArrayList<>();

	// 한 행을 볼수 있게
	private fourletters resultMapping(ResultSet rs) throws SQLException {
		int number = rs.getInt("number");
		String question = rs.getString("question");
		String awnser = rs.getString("awnser");
		String hint = rs.getString("hint");
		return new fourletters(number, question, awnser, hint);
	}

	private Integer favMapping(ResultSet rs) throws SQLException {
//		String id = rs.getString("id");
		int number = rs.getInt("quiznumber");
		return number;
	}
	private favorites favInputMapping(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		int number = rs.getInt("quiznumber");
		return new favorites(id, number);
	}

	// 문제 불러오기
	private fourletters questionMappong(ResultSet rs) throws SQLException {
		String question = rs.getString("question");
		return new fourletters(question);
	}

	// 정답으로 번호불러오기
	private fourletters numberMapping(ResultSet rs) throws SQLException {
		int number = rs.getInt("number");
		return new fourletters(number);
	}

	private fourletters awnserMapping(ResultSet rs) throws SQLException {
		String awnser = rs.getString("awnser");
		return new fourletters(awnser);
	}

	private fourletters hintMapping(ResultSet rs) throws SQLException {
		String hint = rs.getString("hint");
		return new fourletters(hint);
	}

	// 추가를 여러번 할수 있게
	public int[] create(List<fourletters> list) throws SQLException {
		String query = "INSERT INTO fourletters (question, awnser, hint) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			for (fourletters f : list) {
				pstmt.setString(1, f.getQuestion());
				pstmt.setString(2, f.getAwnser());
				pstmt.setString(3, f.getHint());
				pstmt.addBatch();
				// 스테이트먼트가 한줄을 준비하고 반복하면 그 반복을 더해서 준비해줌
				// 같은 쿼리문으로 한것을
				// 똑같은 작업 여러번 할때 배치
			}
			// 익스큐트배치는반복문으로 실행된 것을 한번에 실행하게끔 함
			return pstmt.executeBatch();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

	}

	@Override
	public int create(String question, String awnser, String hint) throws SQLException {
		String query = "INSERT INTO fourletters (question, awnser, hint) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			// 준비과정을 set으로
			pstmt.setString(1, question);
			pstmt.setString(2, awnser);
			pstmt.setString(3, hint);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	// 다푼문제에 저장
	@Override
	public int clearSave(String id, int quizNum) throws SQLException {
		String query = "INSERT INTO attemptsquiz (id, quiznumber) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			// 준비과정을 set으로
			pstmt.setString(1, id);
			pstmt.setInt(2, quizNum);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	@Override
	public List<fourletters> read() throws SQLException {
		String query = "SELECT * FROM fourletters";

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

	// 번호로 문제 불러오기
	@Override
	public fourletters read(int number) throws SQLException {
		String query = "SELECT * FROM fourletters WHERE number = ?";

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
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

		return null;
	}

	// 문제로 번호불러 오기
	@Override
	public fourletters readst(String question) throws SQLException {
		String query = "SELECT * FROM fourletters WHERE question = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return numberMapping(rs);
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return null;
	}

	// 문제로 정답 불러오기
	@Override
	public fourletters readan(String question) throws SQLException {
		String query = "SELECT * FROM fourletters WHERE question = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return awnserMapping(rs);
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return null;
	}

	// 문제로 힌트불러 오기
	@Override
	public fourletters readhint(String question) throws SQLException {
		String query = "SELECT * FROM fourletters WHERE question = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return resultMapping(rs);
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return null;
	}

	@Override
	public int update(int number, String question, String awnser, String hint) throws SQLException {
		String query = "UPDATE fourletters SET question = ?, awnser = ?, hint = ? WHERE number = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			// 준비과정을 set으로
			pstmt.setString(1, question);
			pstmt.setString(2, awnser);
			pstmt.setString(3, hint);
			pstmt.setInt(4, number);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}

//		return 0;
	}

	@Override
	public int delete(int number) throws SQLException {
		String query = "DELETE FROM fourletters WHERE number = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			// 준비과정을 set으로
			pstmt.setInt(1, number);

			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	///////////////////////////////////////////////////////////////
	// 즐겨찾기 메소드
	@Override
	public List<Integer> favread(String id) throws SQLException {
		String query = "SELECT quiznumber FROM favoritesquiz where id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 리스트에 번호만 넣지만 회원 정보도 필요하면
			// favMapping 수정 필요
			while (rs.next()) {
				favlist.add(favMapping(rs));
			}
		} finally {
			QuizDBUtil.closeRS(rs);
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
		return favlist;
	}
	// 번호로 문제 불러 오기

	@Override
	public int readque(int number) throws SQLException {
//		String query = "select question from fourletters AS a\r\n" + 
//				"inner join favoritesquiz_copy AS b ON a.? = b.quiznumber";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = QuizDBUtil.getConnection();
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, number);
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				return favMapping(rs);
//			}
//		} finally {
//			QuizDBUtil.closeRS(rs);
//			QuizDBUtil.closePstmt(pstmt);
//			QuizDBUtil.closeConn(conn);
//		}
		return 1;
	}

	@Override
	public int favoriteUpdate(String id, int number) throws SQLException {
		String query = "INSERT INTO favoritesquiz (id, quiznumber) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, number);
			
//			while (rs.next()) {
//				favlist.add(favMapping(rs));
//			}
			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}

	@Override
	public int favoriteDelete(String id, int number) throws SQLException {
		String query = "DELETE FROM favoritesquiz WHERE quiznumber = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = QuizDBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, number);
			
//			favlist.remove(favMapping(rs));
			
			return pstmt.executeUpdate();
		} finally {
			QuizDBUtil.closePstmt(pstmt);
			QuizDBUtil.closeConn(conn);
		}
	}
	
//	@Override
//	public Integer favoriteSerch(int number) throws SQLException {
////		String query = "SELECT count(?) FROM favoritesquiz GROUP BY ? HAVING COUNT(?) > 1 and quiznumber between 2000 and 2999";
//		String query = "select quiznumber FROM favoritesquiz where quiznumber = ?";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		rs = pstmt.executeQuery();
//		
//		try {
//			conn = QuizDBUtil.getConnection();
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, number);
//
//			if (rs.next()) {
//				return favMapping(rs);
//			}
//		} finally {
//			QuizDBUtil.closePstmt(pstmt);
//			QuizDBUtil.closeConn(conn);
//		}
//	}
}
