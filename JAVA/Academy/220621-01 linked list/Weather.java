import java.time.LocalDate;

public class Weather implements Comparable<Weather> {
	// 1번
//	일기 (날짜, 제목, 날씨, 내용 등)
	private LocalDate day;
	private String title;
	private String weatherType;
	private String content;

	public Weather(LocalDate day) {
		super();
		this.day = day;
	}
	
	public Weather(LocalDate day, String title, String weatherType, String content) {
		super();
		this.day = day;
		this.title = title;
		this.weatherType = weatherType;
		this.content = content;
	}

	public LocalDate getDay() {
		return day;
	}

	public String getTitle() {
		return title;
	}

	public String getWeatherType() {
		return weatherType;
	}

	public String getContent() {
		return content;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "일기 [날짜=" + day + ", 제목=" + title + ", 날씨=" + weatherType + ", 내용=" + content
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		return true;
	}

	@Override
	public int compareTo(Weather o) {
		return content.length() - o.content.length();
	}
}