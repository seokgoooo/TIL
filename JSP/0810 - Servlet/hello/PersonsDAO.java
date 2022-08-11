// Todo : Servlet에서 해결
// 입력값 유효성 검사 필요
// 예외 생길때 (잘못된 값일 때 사용자에게 보여줄 것)
// 한글 깨지는 문제
package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonsDAO {
	public List<Persons> getPersons() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Persons> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM persons");

			while (rs.next()) {
				int id = rs.getInt("personId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				String mail = rs.getString("email");
				list.add(new Persons(id, firstName, lastName, age, mail));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public List<Persons> setInsertPersons(String firstName, String lastName, int age, String mail) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Persons> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			pstmt = conn.prepareStatement("INSERT INTO persons (firstName, lastName, age, email) VALUES (?, ?, ?, ?)");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3, age);
			pstmt.setString(4, mail);
			pstmt.executeUpdate();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

}
