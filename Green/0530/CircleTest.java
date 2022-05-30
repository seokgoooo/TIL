// p203
class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

class Circle {
	private int radius = 0;
	private Point center; // has-a
	
	public Circle(Point p, int r) {
		center = p;
		radius = r;
	}
	
	// 중심점 getter
	public Point getPoint() {
		return center;
	}
	public void setPoint(Point p) {
		center = p;
	}
}

public class CircleTest {
	public static void main(String[] args) {
		Point p = new Point(25, 78);
		Circle c = new Circle(p, 10);
		
		System.out.println(p.getX());
		System.out.println(c.getPoint().getX());
		
		// System.out.println(new Point(34, 22));
	}
}