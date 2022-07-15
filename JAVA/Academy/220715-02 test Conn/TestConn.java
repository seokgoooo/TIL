import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.co.greenart.dbutil.DBUtil;

//	Java build path 를 이용하면 클래스들을 jar 파일로 만든것 뿐만아니라 프로젝트 자체를 포함시킬 수가 있다.

// Example
// my_db.books DB를 이용해
// 도서 관리 프로그램을 만들어 보자
// 1. 추가
// 2. 전체 목록
// 3. (아이디나 제목이나 가격 등으로 검색 가능)
// 4. 삭제
// 5. 수정

public class TestConn {
	public static int insertBook(String title, int price) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			result = stmt
					.executeUpdate("INSERT INTO books (title, price) VALUES (" + "'" + title + "', " + price + ");");
			System.out.println("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	public static void printBooks() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
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
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	public static void searchBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. bookId || 2. title || 3. price");
		int select = sc.nextInt();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			switch (select) {
			case 1:
				int bookId = sc.nextInt();
				result = stmt.executeQuery("SELECT * FROM books WHERE bookID = " + bookId + ";");
				break;

			case 2:
				String title = sc.nextLine();
				result = stmt.executeQuery("SELECT * FROM books WHERE title = " + "'" + title + "'" + ";");
				break;

			case 3:
				int price = sc.nextInt();
				result = stmt.executeQuery("SELECT * FROM books WHERE price = " + price + ";");
				break;

			default:
				break;
			}

			while (result.next()) {
				int id = result.getInt("bookId");
				String title = result.getString("title");
				int price = result.getInt("price");

				System.out.println(id + ", " + title + ", " + price);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRS(result);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	public static int deleteBook(String title) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate("DELETE FROM books WHERE title = " + "'" + title + "'" + ";");
			System.out.println("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	public static int updateBook(String title, int price) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String subTitle = "책2";
		System.out.println("어떤 가격의 책을 바꾸실건가요? ");
		int subPrice = sc.nextInt();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate("UPDATE books SET title = " + "'" + title + "'" + ", price = " + price
					+ " WHERE price = " + subPrice + ";");
			System.out.println("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 2;

//			도서 관리 프로그램
		switch (choice) {
		case 1:
//				추가
			String insertTitle = sc.nextLine();
			int insertPrice = sc.nextInt();
			insertBook(insertTitle, insertPrice);
			break;

		case 2:
//				전체 목록
			printBooks();
			break;

		case 3:
//				(아이디나 제목이나 가격 등으로 검색 가능)
			searchBook();
			break;

		case 4:
//				삭제
			System.out.print("삭제할 책 제목 입력 : ");
			String deleteTitle = sc.nextLine();
			deleteBook(deleteTitle);
			break;

		case 5:
//				수정
			System.out.print("바꾸고 싶은 제목? ");
			String updateTitle = sc.nextLine();
			System.out.print("바꾸고 싶은 가격? ");
			int updatePrice = sc.nextInt();
			updateBook(updateTitle, updatePrice);
			break;

		default:
			break;
		}
	}
}
