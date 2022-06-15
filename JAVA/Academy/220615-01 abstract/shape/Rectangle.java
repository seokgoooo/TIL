package shape;

public class Rectangle extends Shape {
	private int length;
	private int height;

	public Rectangle(int x, int y, int length, int height) {
		super(x, y);
		this.length = length;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getArea() {
		return length * height;
	}
}