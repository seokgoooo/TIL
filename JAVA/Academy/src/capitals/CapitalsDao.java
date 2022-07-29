package capitals;



import java.sql.SQLException;
import java.util.List;

import music.Music;

public interface CapitalsDao {

	void create(int number, String question, String answer, String continent) throws SQLException;

	List<Capitals> read() throws SQLException;
	
	Capitals read(int number) throws SQLException;

	int update(int number, String question, String answer, String continet) throws SQLException;

	int delete(int number) throws SQLException;
}
