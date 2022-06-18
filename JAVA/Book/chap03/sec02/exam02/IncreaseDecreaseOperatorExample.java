package sec02.exam02;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int x = 10;
		int y =10;
		int z;
		
		System.out.println("----------------------------");
		x++;
		++x;
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
		y--;
		--y;
		System.out.println("y=" + y);
		
		System.out.println("----------------------------");
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		System.out.println("----------------------------");
//		z = ++x + y++; 이 줄이랑 아래 식이랑 같은 말인데 아래가 3줄이라도 명확성 가독성이 더 좋아서 아래처럼 쓰는게 바람직하다.
		++x;
		z = x + y;
		y++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}