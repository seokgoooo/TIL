import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class FileDB {
//	파일을 Java에서 관리하면 빠르다 (거치는 단계가 없기 때문에)
//	But DB의 장점 (데이터 활용이 용이함 PK, NN, Unique 등등) 을 활용하려면 DB를 거쳐서 활용하기도 한다.
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

//		DB에 있는 파일 불러오기
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM files WHERE id = ?");
			pstmt.setInt(1, 1000);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Blob file = rs.getBlob("file");

				InputStream inputStream = file.getBinaryStream();
				FileOutputStream fos = new FileOutputStream(new File("다운로드받은거.png"));

				int b = 0;
				while ((b = inputStream.read()) != -1) {
					fos.write(b);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}

//		DB에 파일 저장하기
//		try {
//			conn = DBUtil.getConnection();
//			pstmt = conn.prepareStatement("INSERT INTO files (id, name, file) VALUES (?, ?, ?)");
//			pstmt.setInt(1, 1000);
//			pstmt.setString(2, "파일이름");
//			pstmt.setBlob(3, new FileInputStream(new File("1.png")));
//
//			pstmt.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			DBUtil.closeStmt(pstmt);
//			DBUtil.closeConn(conn);
//		}
	}
}
