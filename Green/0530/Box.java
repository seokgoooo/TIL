public class Box {
	int width;
	int length;
	int height;
	
	public Box(int w, int l, int h) {
		width = w;
		length = l;
		height = h;
	}
	
	public static void main(String[] args) {
		Box b = new Box(50, 60, 70);
		
		System.out.println(b.width);
		System.out.println(b.length);
		System.out.println(b.height);
		
		// 박스 인스턴스화. 생성자를 호출해서 가로 90 세로 100 높이 110
		Box b2 = new Box(90, 100, 110);
	}
}