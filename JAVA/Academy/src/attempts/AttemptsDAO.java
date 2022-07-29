package attempts;

import java.sql.SQLException;
import java.util.List;

public interface AttemptsDAO {
	// 추가
	int create(String id, int quizNumber) throws SQLException;

	// 해당인물이 해당 문제를 몇번? 클리어 여부
	AttemptsQuiz read(String id,int quizNumber) throws SQLException;
	
	// 클리어한 문제만 불러오게
	List<Integer> MusicClearRead(String id, boolean clear) throws SQLException;
	
	List<Integer> fourClearRead(String id, boolean clear) throws SQLException;
	
	List<Integer> capitalClearRead(String id, boolean clear) throws SQLException;

	// 횟수 변경
	int updateCount(String id, int quizNumber, int attemptsCount) throws SQLException;
	
	// 클리어 여부
	int updateClear(String id, int quizNumber, boolean clear) throws SQLException;
	
	// 삭제
	int delete(String id, int quizNumber) throws SQLException;
}
