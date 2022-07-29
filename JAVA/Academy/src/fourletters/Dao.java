package fourletters;
import java.sql.SQLException;
import java.util.List;

public interface Dao {
	int create(String question, String awnser, String hint) throws SQLException;

	List<fourletters> read() throws SQLException;
	fourletters read(int number) throws SQLException;
	fourletters readst(String question) throws SQLException;
	fourletters readan(String question) throws SQLException;
	fourletters readhint(String question) throws SQLException;

	int update(int number, String question, String awnser, String hint) throws SQLException;

	int delete(int number) throws SQLException;

	int clearSave(String id, int quizNum) throws SQLException;
	
	List<Integer> favread(String id) throws SQLException;
	int readque(int number) throws SQLException;
	int favoriteUpdate(String id, int number) throws SQLException;
	int favoriteDelete(String id, int number) throws SQLException;
//	int favoriteSerch(int number) throws SQLException;

}

