package food;
public class TestFood {
	public static void main(String[] args) {
		Food f = new Food(200, 10000, 130);
		System.out.println(f.getCalorie());
		System.out.println(f.getPrice());
		System.out.println(f.getWeight());
		
		Melon m = new Melon(100, 15000, 2000, "델몬트");
		System.out.println(m.getCalorie());
		System.out.println(m.getPrice());
		System.out.println(m.getWeight());
		System.out.println(m.getFarm());
	}
}
