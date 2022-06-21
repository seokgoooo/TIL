import java.time.LocalDate;
import java.util.List;

public interface WeatherManage {
	// 2번
	void add(Weather w);
	List<Weather> list();
	boolean edit(LocalDate day, String content);
	void deleteFirst();
}