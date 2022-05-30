class Time {
	private int time;
	private int minute;
	private int second;
	
	public Time(int t, int m, int s) {
		time = t;
		minute = m;
		second = s;
	}
}

class AlarmClock {
	private Time currentTime;	// has-a 관계 (집합 관계)
	private Time alarmTime;
	// t, m, s 로 시간 표현해놓은 Time 객체를 가져다와서 바로 씀 (변수 만들 필요가 없음)
	
	public AlarmClock(Time a, Time c) {
		alarmTime = a;
		currentTime = c;
	}
}

public class AlarmClockTest {
	public static void main(String[] args) {
		Time alarm = new Time(6, 0, 0);
		Time current = new Time(12, 56, 34);
		AlarmClock c = new AlarmClock(alarm, current);
		System.out.println(c);
	}	// end main
}		// end class