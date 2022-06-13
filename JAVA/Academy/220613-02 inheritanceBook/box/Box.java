package box;

public class Box {
	int width;
	int length;
	int height;

	public Box(int width, int length, int height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public int getVolume() {
		return width * length * height;
	}
}