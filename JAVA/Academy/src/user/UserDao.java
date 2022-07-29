package user;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	// 추가
	int create(String id, String password, boolean manager, int age) throws SQLException;

	// 모든 사람
	public List<User> read() throws SQLException;

	// 특정 인물
	User read(String id) throws SQLException;

	// 정보 수정
	int update(String id, String password, boolean manager, int age) throws SQLException;

	// 삭제
	int delete(String id) throws SQLException;
}