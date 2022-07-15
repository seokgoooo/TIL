import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Main {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
//			forName 에 들어가는 url은 외울필요가 없다 mysql의 경우 OracleDriver 검색해서 찾아서 넣으면 된다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");

//			table A : column B VARCHAR(10) PK 를 만들어보자
//			query문 작성
			String query = "CREATE TABLE A (B VARCHAR(10) PRIMARY KEY)";
			String queryDrop = "DROP TABLE A";

			stmt = conn.createStatement();

//			Statement 인터페이스를 이용해 작성한 query문을 메소드로 전송해주면 된다.
//			stmt.executeUpdate;  (변경용 SELECT 제외하고는 거의 다 된다 : 생성 수정 삭제 등등)
			stmt.executeUpdate(query);
			stmt.executeUpdate(queryDrop);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

//			닫는 순서는 여는 순서 반대로 닫아준다
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