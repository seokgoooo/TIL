import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class Main {
	public static void main(String[] args) {
//		자바에서 제공하는 Connection 객체를 try catch 영역에서 다 사용하고나면 자동적으로 닫아주는 기능이 있다
//		try 소괄호 안에 객체를 선언하고 초기화하는 문장들만 넣어주면 자동적으로 닫아줌 (conn이나 pstmt의 메소드 문장은 쓸수가 없다)
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement("");) {
			pstmt.setString(1, "");
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}