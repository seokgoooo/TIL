package music;
import java.sql.SQLException;
import java.util.List;

public interface MusicDao {

	void create(String title, String singer, String genre, int year) throws SQLException;

	public List<Music> read() throws SQLException;
	
	Music read(int number) throws SQLException;

	int update(int number, String title, String singer, String genre, int year) throws SQLException;

	int delete(int number) throws SQLException;
	
	public int playCountPlus(int number, int playCount) throws SQLException;
}
