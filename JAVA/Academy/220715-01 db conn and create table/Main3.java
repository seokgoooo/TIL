import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 보통 테이블 하나에 객체 하나 연결 해줌
public class Main3 {
	public static Connection makeConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/my_db";
		String id = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void selectAllBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books");
			
			while (rs.next()) {
				int id = rs.getInt("bookId");
				String title = rs.getString("title");
				int price = rs.getInt("price");

				System.out.println(id + ", " + title + ", " + price);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int insertBook(String title, int price) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			result = stmt
					.executeUpdate("INSERT INTO books (title, price) VALUES (" + "'" + title + "', " + price + ");");
			System.out.println(result + "행 추가");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
//		insertBook("새로운 책입니당", 13000);
		selectAllBook();
	}
}