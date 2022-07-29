import java.sql.SQLException;

public interface Dao {

	int create() throws SQLException;

	int read(int number) throws SQLException;

	int update(int number) throws SQLException;

	int delete(int number) throws SQLException;
}
