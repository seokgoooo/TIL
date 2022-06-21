import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class WeatherManageImp implements WeatherManage {
	// 3번
	private List<Weather> list;

	public WeatherManageImp() {
		list = new LinkedList<Weather>();
	}

	@Override
	public void add(Weather w) {
		list.add(w);
	}

	@Override
	public List<Weather> list() {
		return list;
	}

	@Override
	public boolean edit(LocalDate day, String content) {
		int index = list.indexOf(new Weather(day));
		if (index >= 0) {
			Weather d = list.get(index);
			d.setContent(content);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteFirst() {
		if (!list.isEmpty()) {
			list.remove(0);
		}
	}
	
	public void printAll() {
		for (Weather print : list) {
			System.out.println(print);
		}
		System.out.println();
	}
}