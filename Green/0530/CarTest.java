public class CarTest {
	public static void main(String[] args) {
		Car c = new Car("red", 10, 1);
		Car c2 = new Car("yellow");
		Car c3 = new Car("green");
		
		// c.color = "빨강";
		// System.out.println(c.color);
		
		c.setColor("빨강");
		System.out.println(c.getColor());
		
		c.setSpeed(30);
		System.out.println(c.getSpeed());
		
		c.setGear(2);
		System.out.println(c.getGear());
	}
}