import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		// StringBuilder랑 같은 역할이지만 멀티스레드 시 안전하게 구성된 클래스
		StringBuffer sbuffer;

		// String을 만들어주는 클래스 (공간의 효율적 사용 위해)
		// char 의 배열
		StringBuilder sb = new StringBuilder("원본");

		// 문자열을 합쳐주는데 구분 지을 모양을 정해줄 수 있는 클래스
		StringJoiner sj = new StringJoiner(",", "[", "]");
		sj.add("1");
		sj.add("2");
		sj.add("3");
		System.out.println(sj.toString());

		String longLine = "apple banana carrot donut";
		String[] longLineSplit = longLine.split(" ");
		System.out.println(longLineSplit[2].toString());

		// String 을 원하는 " " 기준으로 잘라서 배열로 집어넣는 클래스
		StringTokenizer st = new StringTokenizer(longLine, " ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		sb.append(",One=").append(1).append(",DoubleValue=").append(255.0);
		// 같은말이다
		// append 는 return 을 object의 참조를 반환하기 때문에 가능~
//		sb.append(1);
//		sb.append(",DoubleValue=");
//		sb.append(255.0);

//		sb.reverse();

		sb.setCharAt(0, 'Q');
		sb.insert(0, "시작");
//		sb.replace(start, end, str);

		System.out.println(sb.toString());

		String str = "원본 문자열";
		String other = "다른 문자열";
		String origin = "원본 문자열";

		// String 합연산을 하면 다른 인스턴스가 공간을 차지한다. (공간의 비효율적 사용)
		String concat = str + other;
		System.out.println(concat);
		System.out.println("원본 문자열다른 문자열" == concat);
		System.out.println(str == origin);
	}
}