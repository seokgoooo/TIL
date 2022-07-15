import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
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

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("INSERT INTO books (title, price) VALUES ('SQL 연습', 17000);");
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
	}
}