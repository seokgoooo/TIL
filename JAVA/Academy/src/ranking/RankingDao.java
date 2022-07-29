package ranking;

import java.sql.SQLException;
import java.util.List;

public interface RankingDao {
	// 성공률
	List<Ranking> correctRatio(String table) throws SQLException;

	// 오답률
	List<Ranking> incorrectRatio(String table) throws SQLException;

	// 즐겨찾기 top 5
	List<Ranking> favoriteTop(String table) throws SQLException;

	// 시도많이한 순서
	List<Ranking> maxTest(String table) throws SQLException;

	// 연령대별 인기 게임
	List<Ranking> ageTop(int age) throws SQLException;

	// 종합 순위
	List<Ranking> scoreRank() throws SQLException;
}
