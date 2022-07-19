package teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.greenart.dbutil.DBUtil;

/*
 * restaurants 테이블에 대한 db access를 수행하는 객체를 작성해보세요. 작성 후 테스트!!
 * 
 * 메소드(입력값) : 반환값									throws 예외
 * 
 * C(상호명, 전화번호, 주소) or C(음식점) : 행 개수 				throws SQLException
 * R() : List<음식점> 									throws SQLException
 * R(pk) : 음식점											throws SQLException
 * U(pk, 새 상호명, 새 전화번호, 새 주소) or U(음식점) : 행 개수 	throws SQLException
 * D(pk) : 행 개수 										throws SQLException
 * 
 * ----------------------------------------------------------
 * 
 * 여러 행의 음식점 추가
 */

/*
 *  my_db.books
 * 
 *  도서 관리 프로그램
 *  추가
 *  전체 목록
 *  (아이디나 제목이나 가격 등으로 검색 가능)
 *  삭제
 *  수정
 */

public class TestConn {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT 1");

			if (rs.next()) {
				int result = rs.getInt(1);
				System.out.println("확인 : " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
}
