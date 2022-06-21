import java.util.ArrayList;
import java.util.List;

class Point2D {
	private int x;
	private int y;

	public Point2D(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}

	// 모든 클래스는 Object를 상속받기 때문에 Object에 정의된 equals 메소드가 존재한다.
	// Object의 equals는 참조가 같아야 같다고 판단하기 때문에
	// equals를 재정의해서 원하는 기준을 만들어주면 해결된다.
	// 기준 ex) 타입이 같고 값도 같을 때
	// contains는 equals를 이용해서 동작하는 메소드.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Point2D))
			return false;
		Point2D other = (Point2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class Time {
	public static void main(String[] args) {
		List<Point2D> list = new ArrayList<>();
		list.add(new Point2D(0, 0));
		list.add(new Point2D(5, 5));
		
		Point2D p = list.get(0);
		System.out.println(p);
		System.out.println(list.get(1));
		
		// list에 0, 0 좌표 객체가 있는지?
		System.out.println(list.contains(new Point2D(0, 0)));
		// list에 0, 0 좌표 객체의 인덱스는?
		System.out.println(list.indexOf(new Point2D(0, 0)));
		
		System.out.println(list.remove(new Point2D(5, 5)));
	}
}